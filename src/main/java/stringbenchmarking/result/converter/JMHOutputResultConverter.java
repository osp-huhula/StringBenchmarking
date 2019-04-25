package stringbenchmarking.result.converter;

import stringbenchmarking.commons.exception.UnexpectedEOF;
import stringbenchmarking.result.beans.JMHResult;

public interface JMHOutputResultConverter {

	JMHResult converter(
		String content)
		throws UnexpectedEOF;
}
