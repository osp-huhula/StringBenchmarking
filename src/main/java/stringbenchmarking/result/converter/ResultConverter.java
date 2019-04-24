package stringbenchmarking.result.converter;

import stringbenchmarking.result.beans.JMHResult;

public interface ResultConverter {
	
	JMHResult converter(String content);
	
}
