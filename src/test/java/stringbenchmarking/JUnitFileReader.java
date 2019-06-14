package stringbenchmarking;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import stringbenchmarking.commons.AutoCloser;

public class JUnitFileReader {

	public static  String readFileAsStream(
		String path) {
		return readFile(new File(path));
	}

	public static  String readFileAsStream(
		File file) {
		return readFileAsStream(Thread.currentThread(), file);
	}

	public static  String readFileAsStream(
		Class<?> clazz,
		String path) {
		return readFileAsStream(clazz.getClassLoader(), new File(path));
	}

	public static  String readFileAsStream(
		Thread thread,
		String path) {
		return readFileAsStream(thread, new File(path));
	}

	public static  String readFileAsStream(
		Thread thread,
		File file) {
		ClassLoader loader = thread.getContextClassLoader();
		return readFileAsStream(loader, file);
	}

	public static  String readFileAsStream(
		ClassLoader loader,
		File file) {
		return readFileAsStream(loader, file.getPath());
	}

	public static  String readFile(
		String path) {
		return readFile(new File(path));
	}

	public static  String readFile(
		File file) {
		return readFile(Thread.currentThread(), file);
	}

	public static  String readFile(
		Class<?> clazz,
		String path) {
		return readFile(clazz.getClassLoader(), new File(path));
	}

	public static  String readFile(
		Thread thread,
		String path) {
		return readFile(thread, new File(path));
	}

	public static  String readFile(
		Thread thread,
		File file) {
		ClassLoader loader = thread.getContextClassLoader();
		return readFile(loader, file);
	}

	public static  String readFile(
		ClassLoader loader,
		File file) {
		return readFile(loader, file.getPath());
	}

	public static  String readFileAsStream(
		ClassLoader loader,
		String path) {
		InputStream inputStream = loader.getResourceAsStream(replaceAllSlash(path));
		return readResource(path, inputStream);
	}

	public static  String readFile(
		ClassLoader loader,
		String path) {
		URL resource = loader.getResource(replaceAllSlash(path));
		return readResource(path, resource);
	}

	public static  String readResourceAsStream(
		Class<?> clazz,
		String path) {
		InputStream inputStream = clazz.getResourceAsStream(replaceAllSlash(path));
		return readResource(path, inputStream);
	}

	public static  String readResource(
		Class<?> clazz,
		String path) {
		URL resource = clazz.getResource(replaceAllSlash(path));
		return readResource(path, resource);
	}

	private static String replaceAllSlash(
		String path) {
		return path;// .replaceAll(SLASH, DOUBLE_BACKSLASH);
	}

	public static  String readResource(
		String path,
		InputStream inputStream) {
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

	public static  String readResource(
		String path,
		URL resource) {
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
