package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;

public final class JMHVersionLineConverter
	implements
	JMHResultLineConverter<Double> {

	@Override
	public Double converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		return Double.valueOf(matcher.group(1));
	}

	private String regex() {
		return "# JMH ([1-9]+\\.[0-9]+) \\(released ([1-9]+) days ago, please consider updating!\\)";
	}
}
