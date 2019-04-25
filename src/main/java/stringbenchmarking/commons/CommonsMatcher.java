package stringbenchmarking.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import stringbenchmarking.commons.exception.JMHRuntimeException;

public class CommonsMatcher {

	public static Matcher matcher(
		String regex,
		String content) {
		Matcher matcher = getMarcher(regex, content);
		if (matcher.matches()) {
			return matcher;
		} else {
			throw new JMHRuntimeException(
				String.format("Pattern [%s] doesn't match with content : [%s].", regex, content));
		}
	}

	private static Matcher getMarcher(
		String regex,
		String content) {
		if (regex == null || content == null) {
			throw new JMHRuntimeException("No null parameter allowd.");
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		return matcher;
	}
}
