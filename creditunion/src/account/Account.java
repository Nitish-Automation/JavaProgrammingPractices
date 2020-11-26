package account;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Top level class to hold account information
 * @author nitishsharma
 *
 */

public abstract class Account {
	
	protected BigDecimal balance;
    protected static DecimalFormat df = new DecimalFormat("#.##");

	public Account() {
		super();
	}
	
	/**
	 * Constructor to initialize Account
	 * @param balance : amount to initialize account
	 */
	public Account(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	/**
	 * Method to deposit money to Account
	 * @param ammount : amount to be deposited
	 */
	public abstract void deposit(BigDecimal ammount);
	
	/**
	 * Method to deposit money Account
	 * @param ammount : amount to be withdrawn
	 * @throws OverdraftException custom exception
	 */
	public abstract void withdraw(BigDecimal ammount) throws OverdraftException;

}
