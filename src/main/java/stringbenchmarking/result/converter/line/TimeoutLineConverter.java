package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;

public final class TimeoutLineConverter
	implements
	JMHResultLineConverter<Integer> {

	@Override
	public Integer converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		return Integer.valueOf(matcher.group(1));
	}

	private String regex() {
		return "# Timeout: ([0-9]+) min per iteration";
	}
}
