package example_10_13_custom_exception.exception;

public class UserNotFoundException extends HtaException {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 8057235360366806735L;

	public UserNotFoundException () {}
	 
	 public UserNotFoundException (String message) {
		 super(message);
	 }
	 
	 public UserNotFoundException (String message, Throwable cause) {
		 super(message, cause);
	 }
}
