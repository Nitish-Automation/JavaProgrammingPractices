package customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import account.CheckingAccount;
import account.SavingsAccount;

/**
 * This class is responsible for setting connections and
 * implementing all read and write operations to data base
 * @author nitishsharma
 *
 */
public class DbDriver implements CustomerDAO {
	
    private Connection connect()
    {
        Connection connection = null;
        try
        {
            String dbDirectory = "resources";
            System.setProperty("derby.system.home", dbDirectory);

            String url = "jdbc:derby:CUDB";
            String user = "";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e)
        {
            System.err.println("Error loading database driver: " + e);
        }
        return connection;
    }

    @Override
    public ArrayList<CustomerData> getAllCustomers() {
        try
        {
            Connection connection = connect();
            ArrayList<CustomerData> customers = new ArrayList<CustomerData>();

            String query = "SELECT * FROM CustomerData ORDER BY userEmailId ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {	

            	CustomerData c = new CustomerData();
            	c.setFullName(rs.getString("fullName"));
            	c.setAddress(rs.getString("address"));
            	c.setReferrerEmailId(rs.getString("referrerEmailId"));
            	c.setUserEmailId(rs.getString("userEmailId"));
            	c.setAccountCreatedOn(rs.getString("accountCreatedOn"));
            	c.setAccountDeactivatedOn(rs.getString("accountDeactivatedOn"));
            	c.setCheckingAccount(new CheckingAccount(rs.getBigDecimal("checkingAccount")));
            	c.setSavingsAccount(new SavingsAccount(rs.getBigDecimal("savingsAccount")));
            	c.setDeactivated(rs.getBoolean("isDeactivated"));
               
                customers.add(c);
            }
            rs.close();
            ps.close();
            connection.close();
            return customers;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();  // for debugging
            return null;
        }
    }

    @Override
    public CustomerData getCustomer(String userEmailId) {
        try
        {
            Connection connection = connect();
            String customer =
                "SELECT * FROM CustomerData " +
                "WHERE userEmailId = ?";
            PreparedStatement ps = connection.prepareStatement(customer);
            ps.setString(1, userEmailId);
            ResultSet rs = ps.executeQuery();
            CustomerData c = new CustomerData();
            if (rs.next())
            {	            	
            	c.setFullName(rs.getString("fullName"));
            	c.setAddress(rs.getString("address"));
            	c.setReferrerEmailId(rs.getString("referrerEmailId"));
            	c.setUserEmailId(rs.getString("userEmailId"));
            	c.setAccountCreatedOn(rs.getString("accountCreatedOn"));
            	c.setAccountDeactivatedOn(rs.getString("accountDeactivatedOn"));
            	c.setCheckingAccount(new CheckingAccount(rs.getBigDecimal("checkingAccount")));
            	c.setSavingsAccount(new SavingsAccount(rs.getBigDecimal("savingsAccount")));
            	c.setDeactivated(rs.getBoolean("isDeactivated"));
                
                rs.close();
                ps.close();
                connection.close();
                return c;
            }
            else
                return null;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();   // for debugging
            return null;
        }
    }

    @Override
    public boolean addNewCustomer(CustomerData c)
    {
        try
        {
            Connection connection = connect();
            String insert =
                "INSERT INTO CustomerData (referrerEmailId, userEmailId, fullName, address, savingsAccount, checkingAccount, accountCreatedOn) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, c.getReferrerEmailId());
            ps.setString(2, c.getUserEmailId());
            ps.setString(3, c.getFullName());
            ps.setString(4, c.getAddress());
            ps.setDouble(5, c.getSavingsAccount().getBalance().doubleValue());
            ps.setDouble(6, c.getCheckingAccount().getBalance().doubleValue());
            ps.setString(7, c.getAccountCreatedOn());

            ps.executeUpdate();
            ps.close();
            connection.close();
            return true;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();   // for debugging
            return false;
        }
    }

    @Override
    public boolean updateExistingCustomer(CustomerData c)
    {
        try
        {
            Connection connection = connect();
            String update =
                "UPDATE CustomerData SET " +
                    "referrerEmailId = ?, " +
                    "fullName = ?, " +
                    "address = ?, " +
                    "isDeactivated = ?, " +
                    "savingsAccount = ?, " +
                    "checkingAccount = ?, " +
                    "accountCreatedOn = ?, " +
                    "accountDeactivatedOn = ? " +
                "WHERE userEmailId = ?";
            
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, c.getReferrerEmailId());
            ps.setString(2, c.getFullName());
            ps.setString(3, c.getAddress());
            ps.setBoolean(4, c.isDeactivated());
            ps.setDouble(5, c.getSavingsAccount().getBalance().doubleValue());
            ps.setDouble(6, c.getCheckingAccount().getBalance().doubleValue());
            ps.setString(7, c.getAccountCreatedOn());
            ps.setString(8, c.getAccountDeactivatedOn());
            ps.setString(9, c.getUserEmailId());
                        
            ps.executeUpdate(); 
            ps.close();
            connection.close();
            return true;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();   // for debugging
            return false;
        }
    }

	@Override
	public boolean deactivateCustomer(String customerEmailId) {
		CustomerData cd = getCustomer(customerEmailId);
		cd.setDeactivated(true);
		
		System.out.println("Account Deactivated for " + cd.getFullName());
		return updateExistingCustomer(cd);
	}
}