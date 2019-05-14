package stringbenchmarking.commons;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class ResourceReader {

	public String readFile(
		File file) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		return readFile(loader, file);
	}
	
	public String readFile(
		String path) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		return readFile(loader, path);
	}

	public String readFile(
		ClassLoader loader,
		File file) {
		return readFile(loader, file.getPath());
	}

	public String readFile(
		ClassLoader loader,
		String path) {
		InputStream file = loader.getResourceAsStream(path.replaceAll("/", "\\\\"));
		if (file == null) {
			throw new RuntimeException("Could not load file: ".concat(path));
		}
		try {
			return IOUtils.toString(file, "UTF-8");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (file != null) {
				new AutoCloser().executeClose(file);
			}
		}
	}
}
