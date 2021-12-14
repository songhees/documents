package example_10_13_custom_exception.exception;

public class HtaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8288250392496344916L;

	public HtaException () {}
	
	public HtaException(String message) {
		super(message);
	}

	public HtaException(String message, Throwable cause) {
		super(message, cause);
	}
}