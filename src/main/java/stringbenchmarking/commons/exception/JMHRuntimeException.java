package stringbenchmarking.commons.exception;

public class JMHRuntimeException
	extends
	RuntimeException {

	private static final long serialVersionUID = 1L;

	public JMHRuntimeException(
		String message,
		Throwable cause) {
		super(message, cause);
	}

	public JMHRuntimeException(
		String message) {
		this(message, null);
	}

	public JMHRuntimeException(
		Throwable cause) {
		this(null, cause);
	}
}
