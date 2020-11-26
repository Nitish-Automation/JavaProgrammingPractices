package appdriver;

import java.sql.SQLException;
import java.util.Scanner;

import account.OverdraftException;
import customer.BankConstants;

/**
 * This is Application Driver Class- This class is responsible to interact 
 * with driver and inner modules of application.
 * @author nitishsharma
 *
 */
public class CreditUnionApp {
    private static Scanner sc = null;
	static CustAcctMgmt manager = new CustAcctMgmt();    
    
	public static void main(String[] args) throws SQLException, OverdraftException {
      	
    	printWelcome();    	
    	sc = new Scanner(System.in);
        String action = "";
        
        while (!action.equalsIgnoreCase("0"))
        {
            action = Integer.toString(Validator.getInt(sc, "Enter a command: ", -1, 11));            
            System.out.println();

            if (action.equalsIgnoreCase("1"))
            	manager.displayAllCustomers();
            else if (action.equalsIgnoreCase("2"))
            	manager.addCustomerData(sc);
            else if (action.equalsIgnoreCase("3"))
            	manager.updateCustomerData(sc);
            else if (action.equalsIgnoreCase("4"))
            	manager.depositChecking(sc);
            else if (action.equalsIgnoreCase("5"))
            	manager.withdrawChecking(sc);
            else if (action.equalsIgnoreCase("6"))
            	manager.depositSavings(sc);
            else if (action.equalsIgnoreCase("7"))
            	manager.withdrawSavings(sc);
            else if (action.equalsIgnoreCase("8"))
            	manager.deactivateAccount(sc);
            else if (action.equalsIgnoreCase("9"))
            	printCommandMenu();
            else if (action.equalsIgnoreCase("0"))
            	manager.settleAccounts();
            else
                System.out.println("Error! Not a valid command.\n");
        }
    }
	
	/**
	 * Display application welcome menu for customers
	 */
	private static void printWelcome() {
		System.out.println("##################################################");
        System.out.println("Welcome to the FRIENDS and FAMILY Credit Union!");
		System.out.println("##################################################\n");

		System.out.println("PROMOTIONAL OFFER:\n------------------\n"
				+ "\t-New Customer will get $" + BankConstants.NEW_CUSTOMER_PROMO
				+ " in Savings\n\t-Get a Refferal Bonus of $" + BankConstants.REFFERAL_BONOUS + " in Checking\n");

		printCommandMenu();
	}
	
	/**
	 * Display options for customers
	 */
	private static void printCommandMenu() {
        System.out.println("Please choose from below options...\n");
		System.out.println("Press 1 - To see all existing members");
		System.out.println("Press 2 - To join as a new member");
		System.out.println("Press 3 - To update your name or address");
		System.out.println("Press 4 - To DEPOSIT in CHECKING account");
		System.out.println("Press 5 - To WITHDRAW in CHECKING account");
		System.out.println("Press 6 - To DEPOSIT in SAVINGS account");
		System.out.println("Press 7 - To WITHDRAW in SAVINGS account");
		System.out.println("Press 8 - To Deactivate your account");
		System.out.println("Press 9 - To see the options available");
		System.out.println("Press 0 - Exit this application\n");
	}
}
