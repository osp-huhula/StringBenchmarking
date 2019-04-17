package stringbenchmarking.commons;

import java.io.Closeable;
import java.io.IOException;

public class AutoCloser {

	public void executeClose(
		Closeable obj) {
		if(obj == null) {
			throw new RuntimeException("Parameter can't be null.");
		}
		try {
			obj.close();
		} catch (IOException e) {
			throw new RuntimeException("Couldn't be able to close input-stream", e);
		}
	}
}
