package account;

import java.math.BigDecimal;
import java.text.NumberFormat;


/**
 * This a child class for Account, Takes care of Saving Account functionality
 * @author nitishsharma
 *
 */
public class SavingsAccount extends Account {

	/**
	 * Constructor to initialize SavingsAccount
	 * @param balance : amount to initialize savings account
	 */
	public SavingsAccount(BigDecimal balance) {
		super();
		this.balance= balance;
	}
	
	@Override
	public void deposit(BigDecimal ammount) {
		balance.add(ammount);
	}

	@Override
	public void withdraw(BigDecimal ammount) throws OverdraftException {
		balance.subtract(ammount);
	}
	

	@Override
	public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
		return "Savings: "+currency.format(df.format(balance.doubleValue()));
	}

}
