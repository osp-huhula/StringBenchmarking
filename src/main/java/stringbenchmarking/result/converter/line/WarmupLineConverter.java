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
		String regex = regex(content);
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		Warmup result = new Warmup();
		result.setIterations(Integer.valueOf(matcher.group(1)));
		result.setUnit(matcher.group(2));
		return result;
	}

	private String regex(String content) {
		if(content.startsWith("# Warmup:")) {
			return "# Warmup: ([0-9]+) iterations, ([0-9]+) s each";
		} else {
			return "# Warmup Iteration   ([0-9]+): ([0-9]+,[0-9]+) ns/op";
		}
	}

}
