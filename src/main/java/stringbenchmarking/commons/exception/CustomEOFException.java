package stringbenchmarking.commons.exception;


public class CustomEOFException extends JMHException {

	private static final long serialVersionUID = 1L;
	
	public CustomEOFException() {
		super("EOF.");
	}

}
