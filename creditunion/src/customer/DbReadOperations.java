package customer;
import java.util.ArrayList;

/**
 * Interface to enforce all read operation from database
 * @author nitishsharma
 *
 */
public interface DbReadOperations
{
	/**
	 * Get details for a customer with given email id 
	 * @param email emailid
	 * @return customer data
	 */
    CustomerData getCustomer(String email);
    
    /**
     * Get details for all updated customer objects in database
     * @return ArrayList of customer data
     */
    ArrayList<CustomerData> getAllCustomers();
}