package stringbenchmarking.commons.io;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;

import stringbenchmarking.commons.exception.JMHRuntimeException;

public class ZuzFileReader {

	public String readFile(
		File file) {
		try {
			return IOUtils.toString(new FileInputStream(file), "UTF-8");
		} catch (Exception e) {
			throw new JMHRuntimeException(e);
		}
	}
}
