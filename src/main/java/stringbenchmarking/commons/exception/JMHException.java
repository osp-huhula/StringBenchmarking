package stringbenchmarking.commons.exception;

public class JMHException
	extends
	Exception {

	private static final long serialVersionUID = 1L;

	public JMHException(
		String message,
		Throwable cause) {
		super(message, cause);
	}

	public JMHException(
		String message) {
		this(message, null);
	}

	public JMHException(
		Throwable cause) {
		this(null, cause);
	}
}
