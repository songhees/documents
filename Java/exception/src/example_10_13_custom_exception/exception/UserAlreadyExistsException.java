package example_10_13_custom_exception.exception;

public class UserAlreadyExistsException extends HtaException {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 7506821478114961520L;

	public UserAlreadyExistsException () {}
	 
	 public UserAlreadyExistsException (String message) {
		 super(message);
	 }
	 
	 public UserAlreadyExistsException (String message, Throwable cause) {
		 super(message, cause);
	 }
}
