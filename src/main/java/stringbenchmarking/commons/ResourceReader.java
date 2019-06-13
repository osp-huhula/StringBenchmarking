package stringbenchmarking.commons;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class ResourceReader {

	public String readFileAsStream(
		String path) {
		return readFile(new File(path));
	}

	public String readFileAsStream(
		File file) {
		return readFileAsStream(Thread.currentThread(), file);
	}

	public String readFileAsStream(
		Class<?> clazz,
		String path) {
		return readFileAsStream(clazz.getClassLoader(), new File(path));
	}

	public String readFileAsStream(
		Thread thread,
		String path) {
		return readFileAsStream(thread, new File(path));
	}

	public String readFileAsStream(
		Thread thread,
		File file) {
		ClassLoader loader = thread.getContextClassLoader();
		return readFileAsStream(loader, file);
	}

	public String readFileAsStream(
		ClassLoader loader,
		File file) {
		return readFileAsStream(loader, file.getPath());
	}

	public String readFile(
		String path) {
		return readFile(new File(path));
	}

	public String readFile(
		File file) {
		return readFile(Thread.currentThread(), file);
	}

	public String readFile(
		Class<?> clazz,
		String path) {
		return readFileAsStream(clazz.getClassLoader(), new File(path));
	}

	public String readFile(
		Thread thread,
		String path) {
		return readFile(thread, new File(path));
	}

	public String readFile(
		Thread thread,
		File file) {
		ClassLoader loader = thread.getContextClassLoader();
		return readFile(loader, file);
	}

	public String readFile(
		ClassLoader loader,
		File file) {
		return readFile(loader, file.getPath());
	}

	public String readFileAsStream(
		ClassLoader loader,
		String path) {
		InputStream inputStream = loader.getResourceAsStream(path.replaceAll("/", "\\\\"));
		if (inputStream == null) {
			throw new RuntimeException("Could not load file: ".concat(path));
		}
		try {
			return IOUtils.toString(inputStream, "UTF-8");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null) {
				new AutoCloser().executeClose(inputStream);
			}
		}
	}

	public String readFile(
		ClassLoader loader,
		String path) {
		URL resource = loader.getResource(path.replaceAll("/", "\\\\"));
		if (resource == null) {
			throw new RuntimeException("Could not load file: ".concat(path));
		}
		try {
			return IOUtils.toString(resource, "UTF-8");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
