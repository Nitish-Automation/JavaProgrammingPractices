package customer;

import java.util.ArrayList;

/**
 * This class is responsible for implementing functionality to mange customer data
 * It has a composition association with DnDriver and uses that for connecting to DB
 * @author nitishsharma
 *
 */

public class CustomerManager {
	
    private static DbDriver dbdriver = new DbDriver();
    
    /**
     * To onboard new customers
     * @param data cuatomer data
     */
	public void addNewCustomer(CustomerData data) {
		if (data != null)
			dbdriver.addNewCustomer(data);
		else
			System.out.println("New Customer Account NOT Created. Try Again!");
	}

	/**
	 * To dectivate and existing account
	 * @param customerEmailId emailid
	 */
	public void deactivateCustomer(String customerEmailId) {
		if(isExistingCustomer(customerEmailId)) {
			
			if (!dbdriver.deactivateCustomer(customerEmailId))
				System.out.println("Soory Account Not Aactivated, Please Try Again!");
		}
	}

	/**
	 * Get list of all valid customers
	 * @return Arraylist of customers
	 */
	public ArrayList<CustomerData> getAllCustomers() {
		return dbdriver.getAllCustomers();
	}

	/**
	 * Validate and get customer details
	 * @param customerEmailId emailid
	 * @return customer data
	 */
	public CustomerData getCustomer(String customerEmailId) {
		if (isExistingCustomer(customerEmailId))
			return dbdriver.getCustomer(customerEmailId);
		return null;
	}

	/**
	 * Update name and address of customer
	 * @param data customerdata obj
	 */
	public void updateExistingCustomer(CustomerData data) {
		if (data != null)
			dbdriver.updateExistingCustomer(data);
		else {
			System.out.println("Customer Account NOT Updated. Try Again!");
		}
	}

	/**
	 * To validate if a customer is existing or not
	 * @param userEmailId emailid
	 * @return boolean
	 */
	public boolean isExistingCustomer(String userEmailId) {

		for (CustomerData cd : getAllCustomers()) {
			if (cd.getUserEmailId().equalsIgnoreCase(userEmailId) && !cd.isDeactivated())
				return true;
		}

		return false;
	}

}
