package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;

public final class ResultNameLineConverter
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
		return "Result \"(.+)\":";
	}
}
