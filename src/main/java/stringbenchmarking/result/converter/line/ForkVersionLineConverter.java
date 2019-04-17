package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.Fork;

public final class ForkVersionLineConverter
	implements
	JMHResultLineConverter<Fork> {

	@Override
	public Fork converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		Fork result = new Fork();
		result.setIndex(Integer.valueOf(matcher.group(1)));
		result.setTotal(Integer.valueOf(matcher.group(2)));
		return result;
	}

	private String regex() {
		return "# Fork: ([0-9]+) of ([0-9]+)";
	}
}
