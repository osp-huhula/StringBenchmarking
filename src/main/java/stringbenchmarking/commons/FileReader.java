package stringbenchmarking.commons;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class FileReader {

	public String readFile(
		String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream file = classLoader.getResourceAsStream(fileName);
		if (file == null) {
			throw new RuntimeException("Could not load file: ".concat(fileName));
		}
		try {
			return IOUtils.toString(file, "UTF-8");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if(file != null) {
				new AutoCloser().executeClose(file);
			}
		}
	}
	
	

}
