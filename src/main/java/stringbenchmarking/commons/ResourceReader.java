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
		return readFile(clazz.getClassLoader(), new File(path));
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
		return readResource(ResourceRParameter.asInputStream(loader, path));
	}

	public String readFile(
		ClassLoader loader,
		String path) {
		return readResource(ResourceRParameter.asURL(loader, path));
	}

	public String readResourceAsStream(
		Class<?> clazz,
		String path) {
		return readResource(ResourceRParameter.asInputStream(clazz, path));
	}

	public String readResource(
		Class<?> clazz,
		String path) {
		return readResource(ResourceRParameter.asURL(clazz, path));
	}

	public String readResource(
		String path,
		URL resource) {
		return readResource(ResourceRParameter.get(resource, path));
	}

	public String readResource(
		String path,
		InputStream resource) {
		return readResource(ResourceRParameter.get(resource, path));
	}

	public <T> String readResource(
		ResourceRParameter<T> resource) {
		if (resource.notFound()) {
			throw new RuntimeException("Could not load file: ".concat(resource.getPath()));
		}
		try {
			return resource.read();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			resource.closeResource();
		}
	}
}

abstract class ResourceRParameter<T> {

	public static ResourceRParameter<Object> get(
		Object resource,
		String path) {
		return new ResourceRParameter<Object>(resource, path) {

			@Override
			void closeResource() {
			}
		};
	}

	public static ResourceRParameter<URL> asURL(
		ClassLoader loader,
		String path) {
		return new ResourceRParameterURL(loader.getResource(path), path);
	}

	public static ResourceRParameter<URL> asURL(
		Class<?> clazz,
		String path) {
		return new ResourceRParameterURL(clazz.getResource(path), path);
	}

	public static ResourceRParameter<InputStream> asInputStream(
		ClassLoader loader,
		String path) {
		return new ResourceRParameterIP(loader.getResourceAsStream(path), path);
	}

	public static ResourceRParameter<InputStream> asInputStream(
		Class<?> clazz,
		String path) {
		return new ResourceRParameterIP(clazz.getResourceAsStream(path), path);
	}

	private static final String ENCODE = "UTF-8";
	private T resource;
	private String path;

	private ResourceRParameter(
		T resource,
		String path) {
		super();
		this.path = path;
		this.resource = resource;
	}

	protected T getResource() {
		return resource;
	}

	public String read()
		throws IOException {
		if (resource instanceof InputStream) {
			return IOUtils.toString((InputStream) resource, ENCODE);
		}
		if (resource instanceof URL) {
			return IOUtils.toString((URL) resource, ENCODE);
		}
		throw new IllegalArgumentException(resource.getClass().getName());
	}

	public boolean notFound() {
		return resource == null;
	}

	abstract void closeResource();

	public String getPath() {
		return path;
	}

	private static class ResourceRParameterURL
		extends
		ResourceRParameter<URL> {

		private ResourceRParameterURL(
			URL resource,
			String path) {
			super(resource, path);
		}

		@Override
		void closeResource() {
		}
	}

	private static class ResourceRParameterIP
		extends
		ResourceRParameter<InputStream> {

		private ResourceRParameterIP(
			InputStream resource,
			String path) {
			super(resource, path);
		}

		@Override
		void closeResource() {
			if (notFound()) {
				new AutoCloser().executeClose(getResource());
			}
		}
	}
}
