package example_10_13_custom_exception.exception;

public class PasswordMismatchException extends HtaException {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 3780776167227257788L;

	public PasswordMismatchException () {}
	 
	 public PasswordMismatchException (String message) {
		 super(message);
	 }
	 
	 public PasswordMismatchException (String message, Throwable cause) {
		 super(message, cause);
	 }
}
