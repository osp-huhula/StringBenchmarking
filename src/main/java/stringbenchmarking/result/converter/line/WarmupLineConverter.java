package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.WarmUp;

public final class WarmupLineConverter
	implements
	JMHResultLineConverter<WarmUp> {

	@Override
	public WarmUp converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		WarmUp result = new WarmUp();
		result.setIterations(Integer.valueOf(matcher.group(1)));
		result.setSeconds(Integer.valueOf(matcher.group(2)));
		return result;
	}

	private String regex() {
		return "# Warmup: ([0-9]+) iterations, ([0-9]+) s each";
	}
}
