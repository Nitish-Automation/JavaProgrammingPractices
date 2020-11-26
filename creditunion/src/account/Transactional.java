package account;

import java.math.BigDecimal;

/**
 * Interface for all the transactions in the Account type objects
 * @author nitishsharma
 *
 */
public interface Transactional {
	
	/**
	 * Method to Withdraw amount from Given Account type
	 * @param acc : Account
	 * @param ammoutToBeDeducted : BigDecimal
	 * @return withdrawn amount in BigDecimal
	 * @throws OverdraftException custom exception
	 */
	public abstract BigDecimal withdaw(Account acc, BigDecimal ammoutToBeDeducted) throws OverdraftException;
	
	/**
	 * Method to Deposit amount from Given Account type
	 * @param acc : Account
	 * @param ammoutToBeDeposited : BigDecimal
	 * @return withdrawn amount in BigDecimal
	 */
	public abstract BigDecimal deposit(Account acc, BigDecimal ammoutToBeDeposited);
	
	/**
	 * Method to charge fee from Given Account type
	 * @param acc : Account
	 * @param fee : BigDecimal
	 */
	public abstract void chargeFee(Account acc, BigDecimal fee);
	
	/**
	 * Method to pay interest amount from Given Account type
	 * @param acc : Account
	 * @param interest : BigDecimal
	 */
	public abstract void payInterest(Account acc, BigDecimal interest);

}
