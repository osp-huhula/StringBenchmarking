package stringbenchmarking.result.converter;

import java.io.File;

import stringbenchmarking.commons.exception.UnexpectedEOF;
import stringbenchmarking.result.beans.JMHResult;

public interface JMHOutputResultConverter {

	JMHResult converter(
		File file)
		throws UnexpectedEOF;
}
