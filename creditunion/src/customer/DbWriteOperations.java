package customer;

/**
 * Interface to enforce all read operation from database
 * @author nitishsharma
 *
 */
public interface DbWriteOperations
{	
	/**
	 * Add new customer
	 * @param c customerdata
	 * @return boolean
	 */
    boolean addNewCustomer(CustomerData c);
    
    /**
     * Update customer data
     * @param c customerdata
     * @return boolean
     */
    boolean updateExistingCustomer(CustomerData c);
    
    /**
     * To activate customer
     * @param customerEmailId emailid
     * @return boolean
     */
	boolean deactivateCustomer(String customerEmailId);

}