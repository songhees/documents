package example_10_13_exception;

public class CustomerNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4202042761558481192L;

	public CustomerNotFoundException () {}
	
	public CustomerNotFoundException (String message){
		super(message);
	}
	
	public CustomerNotFoundException (Throwable cause) {
		super(cause);
	}

	public CustomerNotFoundException (String message, Throwable cause) {
		super(message, cause);
	}
	
}
