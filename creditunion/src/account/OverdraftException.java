package account;

/**
 * Custom exception class
 * @author nitishsharma
 *
 */
@SuppressWarnings("serial")
public class OverdraftException extends Exception {
	
	/**
	 * Method to display Message for Overdraft exception
	 * @param message : Exception message
	 */
	public OverdraftException(String message) {
		super(message);
	}

}
