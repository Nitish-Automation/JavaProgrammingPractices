package account;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * This a child class for Account, Takes care of Checking Account transactions
 * @author nitishsharma
 *
 */
public class CheckingAccount extends Account {
	
	/**
	 * Constructor to initialize CheckingAccount
	 * @param balance : amount to initialize checking account
	 */
	public CheckingAccount(BigDecimal balance) {
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
		return "Checking: "+currency.format(df.format(balance.doubleValue()));
	}
	
}
