package customer;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import account.CheckingAccount;
import account.SavingsAccount;

/**
 * Class to create customer data and reading and writing customer object to database
 * @author nitishsharma
 *
 */
public class CustomerData {
	
	private String referrerEmailId;
	private String userEmailId;
	private String fullName;
	private String address;
	private boolean isDeactivated;
	private SavingsAccount savingsAccount;
	private CheckingAccount checkingAccount;
	private String accountCreatedOn;
	private String accountDeactivatedOn;
	
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
    static NumberFormat currency = NumberFormat.getCurrencyInstance();
    protected static DecimalFormat df = new DecimalFormat("#.##");

	public CustomerData() {
		super();
	}
    
	public CustomerData(String referrerEmailId, String userEmailId, String fullName, String address) {
		this.referrerEmailId = referrerEmailId;
		this.userEmailId = userEmailId;
		this.fullName = fullName;
		this.address = address;
		this.accountCreatedOn=getCurrentDate();
	}

	public String getReferrerEmailId() {
		return referrerEmailId;
	}

	public void setReferrerEmailId(String referrerEmailId) {
		this.referrerEmailId = referrerEmailId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isDeactivated() {
		return isDeactivated;
	}

	public void setDeactivated(boolean isDeactivated) {
		if(isDeactivated)
			setAccountDeactivatedOn(getCurrentDate());
		this.isDeactivated = isDeactivated;
	}
	
	public String getAccountCreatedOn() {
		return accountCreatedOn;
	}
	
	public void setAccountCreatedOn(String accountCreatedOn) {
		this.accountCreatedOn = accountCreatedOn;
	}
	
	public String getAccountDeactivatedOn() {
		return accountDeactivatedOn;
	}
	
	public void setAccountDeactivatedOn(String accountDeactivatedOn) {
		this.accountDeactivatedOn = accountDeactivatedOn;
	}

	private String getCurrentDate() {
	    Date date = new Date();  
		return formatter.format(date);
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}
	
	
	@Override
	public String toString() {
		return "CustomerData :\nreferrerEmailId=" + referrerEmailId 
				+ "\nuserEmailId=" + userEmailId 
				+ "\nfullName="+ fullName 
				+ "\naddress=" + address 
				+ "\nisDectivated=" + isDeactivated 
				+ "\nsavingsAccountBal="+ currency.format(savingsAccount.getBalance())
				+ "\ncheckingAccountBal=" + currency.format(checkingAccount.getBalance())
				+ "\naccountCreatedOn=" + accountCreatedOn
				+ "\naccountDeactivatedOn=" + accountDeactivatedOn;
	}

}
