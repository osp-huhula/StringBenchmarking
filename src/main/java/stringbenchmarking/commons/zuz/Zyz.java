package stringbenchmarking.commons.zuz;

public class Zyz {

	public static void out(
		Object value) {
		System.out.println(value);
	}

	public static void out(
		String value) {
		System.out.println(value);
	}

	public static void err(
		Object value) {
		System.err.println(value);
	}

	public static void err(
		String value) {
		System.err.println(value);
	}

	public static void err(
		String value,
		Exception e) {
		System.err.println(value);
		e.printStackTrace();
	}
}
