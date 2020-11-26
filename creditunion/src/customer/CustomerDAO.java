package customer;

/**
 * Interface to implement DB read and write operations
 * This interface will be implemented by any class responsible 
 * for reading and writing to specific data source
 * 
 * @author nitishsharma
 *
 */
public interface CustomerDAO extends DbReadOperations, DbWriteOperations {
		
}