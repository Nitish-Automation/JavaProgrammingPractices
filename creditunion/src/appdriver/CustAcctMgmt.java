package appdriver;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import account.AccountManager;
import account.CheckingAccount;
import account.OverdraftException;
import account.SavingsAccount;
import customer.BankConstants;
import customer.CustomerData;
import customer.CustomerManager;

/**
 * This class is works as bridge between App and Inner modules of the system
 * It is associated with CustomerManager and AccountManager via composition.
 * @author nitishsharma
 *
 */

public class CustAcctMgmt {
	
	CustomerManager custmgr = new CustomerManager();
	AccountManager acctmgr = new AccountManager();
	
	Set<CustomerData> activeUsers = new HashSet<CustomerData>();
    static NumberFormat currency = NumberFormat.getCurrencyInstance();

    /**
     * To print all customers list in the console
     */
	public void displayAllCustomers() {
		System.out.println("================== Existing Customers ==================");
		for (CustomerData cd: custmgr.getAllCustomers()) {
			System.out.println("Name: "+cd.getFullName()+"\t"+"Email: "+cd.getUserEmailId()+"\n");
			System.out.println(cd+"\n\n");
		}
		System.out.println("========================================================");

	}
	
	/**
	 * To call customer manager and account manger for addin new customer and initialize promo balance 
	 * @param sc Scanner
	 */
	public void addCustomerData(Scanner sc)  {	
		
        String referrerEmailId = getValidEmailExistingCustomer(sc, "Enter email id of your refferer: ");
        if(referrerEmailId==null)
        	return;

        String userEmailId = getValidEmailNewCustomer(sc, "Enter your email id: ");
        if(userEmailId==null)
        	return;
        
        if(custmgr.isExistingCustomer(userEmailId)) {
        	System.out.println("You already have an Account with us.\nPress 'Enter' for main menu");
            sc.nextLine();
        	return;
        }
                
        String fullName = Validator.getLine(sc, "What is your full name: ");
        String address = Validator.getLine(sc, "What is your address: ");
        
        BigDecimal checkingAccountBal = new BigDecimal(0);
        while(checkingAccountBal.intValue()<1) {
        	checkingAccountBal = Validator.getBigDecimal(sc, "How much you want to deposit in your checking accout: ");
        	if (checkingAccountBal.intValue()<1)
        		System.out.println("Your Opening Balance Must Be Atleast $1.00");
        }
        
        CustomerData cust = new CustomerData(referrerEmailId, userEmailId, fullName, address);
        cust.setCheckingAccount(new CheckingAccount(checkingAccountBal));
        
        BigDecimal savingsAccountBal = new BigDecimal(BankConstants.NEW_CUSTOMER_PROMO);
        cust.setSavingsAccount(new SavingsAccount(savingsAccountBal));
        
        custmgr.addNewCustomer(cust);
        payRefferalBonus(referrerEmailId);
        System.out.println();
        System.out.println("Congratulations '"+fullName+"' you are new Member of FnF CU\n");
    } 

	/**
	 * To get valid email from DB
	 * @param sc Scanner
	 * @param message message
	 * @return email
	 */
	private String  getValidEmailExistingCustomer(Scanner sc, String message) {
        String email = null;
        int attempt=1;
        while(email==null) {
        	
        	if(attempt>3) {
            	System.out.println("Sorry, no more retries.");
                sc.nextLine();
            	return null;
        	}

        	email = Validator.getEmailString(sc, message);
            if(!custmgr.isExistingCustomer(email)) {
            	System.out.println("Please Enter a Valid Email Id, NO active acount found");
            	email=null;
            	attempt++;
                sc.nextLine();
            }   
        }
		return email;		
	}
	
	/**
	 * To Get a email id in a valid format
	 * @param sc Scanner
	 * @param message message
	 * @return email
	 */
	private String  getValidEmailNewCustomer(Scanner sc, String message) {
        String email = null;
        int attempt=1;
        while(email==null) {
        	
        	if(attempt>3) {
            	System.out.println("Sorry, no more retries. Press 'Enter' for main menu.");
                sc.nextLine();
            	return null;
        	}

        	email = Validator.getEmailString(sc, message);
            if(!custmgr.isExistingCustomer(email) && email!=null) {
                sc.nextLine();
            	return email;

            }
            else {
            	attempt++;
                sc.nextLine();
            }
        }
		return email;		
	}

	/**
	 * To pay refferal bonus to referre's checking account
	 * @param referrerEmailId emailid
	 */
	private void payRefferalBonus(String referrerEmailId) {
		
		CustomerData cust = custmgr.getCustomer(referrerEmailId);
		CheckingAccount chkac = cust.getCheckingAccount();
		chkac.setBalance(chkac.getBalance().add(new BigDecimal(BankConstants.REFFERAL_BONOUS)));
		cust.setCheckingAccount(chkac);
		custmgr.updateExistingCustomer(cust);
	} 

	/**
	 * To update customer's account for name and address
	 * @param sc Scanner
	 */
	public void updateCustomerData(Scanner sc) {
        String userEmailId = Validator.getString(sc, "Enter your email id: ");
        CustomerData cd = custmgr.getCustomer(userEmailId);
        
        if(cd!=null) {
        	
            String fullName = Validator.getLine(sc, "What is your updated full name: ");
            String address = Validator.getLine(sc, "What is your updated address: ");
        	cd.setFullName(fullName);
        	cd.setAddress(address);
   		
        	custmgr.updateExistingCustomer(cd);
			System.out.println("Account info Updated Successfully!\nPress 'Enter' to choose an option.");
            sc.nextLine();
        }
        else {
        	System.out.println("Account NOT Found");
        	return;
        }
	}
	
	/**
	 * Run checking deposit operation on desired customer
	 * @param sc Scanner
	 */
	public void depositChecking(Scanner sc) {
	    CustomerData cd = getCustomerData(sc);
	    if(cd==null)
	    	return;

		CheckingAccount chkac = cd.getCheckingAccount();
		BigDecimal depositAmount = Validator.getBigDecimal(sc, "How much you want to deposit in your checking accout: ");
		
		acctmgr.deposit(chkac, depositAmount);
		custmgr.updateExistingCustomer(cd);
		
		System.out.println("Deposit Success! Your new balance is " + currency.format(chkac.getBalance())+". Press 'Enter' to continue.");

		activeUsers.add(cd);
		sc.nextLine();

	}

	/**
	 * To run checking withdrawal operations on desired account
	 * @param sc Scanner
	 * @throws OverdraftException exception
	 */
	public void withdrawChecking(Scanner sc) throws OverdraftException {
	    CustomerData cd = getCustomerData(sc);
	    if(cd==null)
	    	return;
	      
	    CheckingAccount chkac = cd.getCheckingAccount();
	    BigDecimal withdrawAmount = Validator.getBigDecimal(sc, "How much you want to withdraw from your checking accout: ");
	    acctmgr.withdaw(chkac, withdrawAmount);
		custmgr.updateExistingCustomer(cd);

	    System.out.println("WithDrawal Success! Your new balance is "+ currency.format(chkac.getBalance())+". Press 'Enter' to continue.");
	    activeUsers.add(cd);
	    sc.nextLine();
	
	}

	/**
	 * To run savings deposit to desired account
	 * @param sc Scanner
	 */
	public void depositSavings(Scanner sc) {  	  
	      CustomerData cd = getCustomerData(sc);
	      if(cd==null)
	    	  return;
	      
	      SavingsAccount savac = cd.getSavingsAccount();
	      BigDecimal depositAmount = Validator.getBigDecimal(sc, "How much you want to deposit in your savings accout: ");
	      
	      acctmgr.deposit(savac, depositAmount);
	      custmgr.updateExistingCustomer(cd);

	      System.out.println("Deposit Success! Your new balance is "+currency.format(savac.getBalance())+". Press 'Enter' to continue.");
	      activeUsers.add(cd);
	      sc.nextLine();	
	}

	/**
	 * To run savings withdrawal operations on desired account
	 * @param sc Scanner
	 * @throws OverdraftException exception
	 */
	public void withdrawSavings(Scanner sc) throws OverdraftException {
	      CustomerData cd = getCustomerData(sc);
	      if(cd==null)
	    	  return;
	      
	      SavingsAccount savac = cd.getSavingsAccount();
	      BigDecimal depositAmount = Validator.getBigDecimal(sc, "How much you want to withdraw in your savings accout: ");

	      acctmgr.withdaw(savac, depositAmount);
	      custmgr.updateExistingCustomer(cd);
	      
	      System.out.println("Deposit Success! Your new balance is "+currency.format(savac.getBalance())+". Press 'Enter' to continue.");
	      activeUsers.add(cd);
	      sc.nextLine();
	}

	/**
	 * To settle accounts after charging fee and paying interest
	 */
	public void settleAccounts() {
		
		for (CustomerData cd:activeUsers) {
			acctmgr.chargeFee(cd.getCheckingAccount(), new BigDecimal(BankConstants.TRANSACTION_FEE));
			acctmgr.payInterest(cd.getSavingsAccount(), new BigDecimal(BankConstants.INTEREST_RATE));
			custmgr.updateExistingCustomer(cd);
			System.out.println("\nCharging Transaction Fee $"+BankConstants.TRANSACTION_FEE+" to "+cd.getFullName()
			+"\nUpdated Checking Account balance is "+currency.format(cd.getCheckingAccount().getBalance()));
			System.out.println("\nPaying Interest of "+BankConstants.INTEREST_RATE+"% to "+cd.getFullName()
			+"\nUpdated Savings Account balance is "+currency.format(cd.getSavingsAccount().getBalance()));
		}
		
        System.out.println("\nTHANKS for visiting...\n");

	}

	/**
	 * To get customer data
	 * @param sc Scanner
	 * @return CustomerData
	 */
	private CustomerData getCustomerData(Scanner sc) {
	      String userEmailId = Validator.getString(sc, "Enter your email id: ");
	      
	      if(!custmgr.isExistingCustomer(userEmailId)) {
	          System.out.println("Sorry! '"+userEmailId+"' is NOT associated with any account.");
	          return null;
	      }
	      
	      CustomerData cd = null;
	      for (CustomerData acd: activeUsers) {
	    	  if(acd.getUserEmailId().equalsIgnoreCase(userEmailId))
	    		  cd=acd;
	      }
	      
	      if(cd==null)
	 		 cd = custmgr.getCustomer(userEmailId);
		
		return cd;
	}

	/**
	 * To deactivate account
	 * @param sc Scanner
	 */
	public void deactivateAccount(Scanner sc) {
		String customerEmailId = getValidEmailExistingCustomer(sc, "Enter Email id for the account to be deactivated ");
		custmgr.deactivateCustomer(customerEmailId);
	}
	
}
