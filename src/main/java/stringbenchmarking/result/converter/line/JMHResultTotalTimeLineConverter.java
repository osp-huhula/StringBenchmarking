package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;

public final class JMHResultTotalTimeLineConverter
	implements
	JMHResultLineConverter<String> {

	@Override
	public String converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		return matcher.group(1);
	}

	private String regex() {
		return "# Run complete\\. Total time: ([0-9]{2}:[0-9]{2}:[0-9]{2})";
	}
}
