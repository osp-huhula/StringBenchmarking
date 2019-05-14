package stringbenchmarking.io;

import stringbenchmarking.commons.zuz.ZuzSerializer;
import stringbenchmarking.result.beans.JMHResultImp;

public class JMHResultSerializer {

	public static byte[] serializing(
		JMHResultImp result) {
		return ZuzSerializer.serializing(result);		
	}

	public static JMHResultImp deserialization(
		byte[] value) {
		return ZuzSerializer.deserialization(value);
	}
}
