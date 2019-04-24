package stringbenchmarking.commons.exception;

import stringbenchmarking.result.beans.JMHResultImp;

public class UnexpectedEOF
	extends
	JMHException {

	private static final long serialVersionUID = -5962095822866635113L;
	
	private final JMHResultImp result;

	public UnexpectedEOF(
		JMHResultImp result,
		CustomEOFException cause) {
		super(cause);
		this.result = result;
	}

	public JMHResultImp getResult() {
		return result;
	}
}
