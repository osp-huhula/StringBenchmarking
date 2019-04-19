package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.Warmup;

public final class WarmupLineConverter
	implements
	JMHResultLineConverter<Warmup> {

	@Override
	public Warmup converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		Warmup result = new Warmup();
		result.setIterations(Integer.valueOf(matcher.group(1)));
		result.setSeconds(Integer.valueOf(matcher.group(2)));
		return result;
	}

	private String regex() {
		return "# Warmup: ([0-9]+) iterations, ([0-9]+) s each";
	}
}
