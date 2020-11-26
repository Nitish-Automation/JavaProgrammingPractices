package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is for one time database and table creation to store customer and account information 
 * @author nitishsharma
 *
 */
public class DbCreator {
	
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:./resources/CUDB;create=true";
	public static Connection connection;
	public static void createDatabase() throws SQLException {    		
        try {
        	
        	Class.forName(DRIVER);
        	connection = DriverManager.getConnection(JDBC_URL);
        	 	
        	Statement statement = connection.createStatement();
        	String sql = "CREATE TABLE CustomerData ("
        			+ "referrerEmailId VARCHAR(50), "
        			+ "userEmailId VARCHAR(50), "
        			+ "fullName VARCHAR(100), "
        			+ "address VARCHAR(250), "
        			+ "isDeactivated BOOLEAN, "
        			+ "savingsAccount DOUBLE, "
        			+ "checkingAccount DOUBLE, "
        			+ "accountCreatedOn VARCHAR(50), "
        			+ "accountDeactivatedOn VARCHAR(50), "
        			+ "PRIMARY KEY (userEmailId))";
        	        	
        	statement.execute(sql);
        	
		}
        catch (Exception e) {
        	e.printStackTrace();
		}

        finally {
        	connection.close();
        }
	}

}
