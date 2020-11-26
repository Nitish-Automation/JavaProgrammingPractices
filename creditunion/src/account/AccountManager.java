package account;

import java.math.BigDecimal;

/**
 * Class to mange all the activity and transactions into the Accounts
 * @author nitishsharma
 *
 */
public class AccountManager implements Transactional {

	
	@Override
	public BigDecimal withdaw(Account acc, BigDecimal ammoutToBeDeducted) throws OverdraftException {
		
		BigDecimal newTotal = null;
		
		if (acc!=null) {
			newTotal = acc.getBalance().subtract(ammoutToBeDeducted);
			
			if (newTotal.intValue()<1)
				throw new OverdraftException("Sorry, you cannot withdraw more than $"+(acc.getBalance().intValue()-1));
			else
				acc.setBalance(newTotal);
		}

		return newTotal;
	}

	@Override
	public BigDecimal deposit(Account acc, BigDecimal ammoutToBeDeposited) {
		
		if (acc!=null) {
			BigDecimal newTotal = acc.getBalance().add(ammoutToBeDeposited);
			acc.setBalance(newTotal);
			return newTotal;
		}
		return null;

	}

	@Override
	public void chargeFee(Account account, BigDecimal fee) {
			
		if (account!=null && account instanceof CheckingAccount) {
			BigDecimal newTotal = account.getBalance().subtract(fee);
			account.setBalance(newTotal);
		}

	}

	@Override
	public void payInterest(Account account, BigDecimal interest) {
		
		if (account instanceof SavingsAccount) {
			BigDecimal newTotal = account.getBalance().multiply(interest);
			newTotal = newTotal.divide(new BigDecimal(100));
			account.setBalance(account.getBalance().add(newTotal));
		}
		
	}

}
