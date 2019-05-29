package stringbenchmarking.commons.zuz;

public class ZuzString {

	public static String normalizeASCII(
		String content) {
		return content.replaceAll("[^\\x20-\\x7e]", "");
	}
}
