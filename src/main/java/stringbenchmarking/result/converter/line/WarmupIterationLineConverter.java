package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.WarmupMeasure;

public final class WarmupIterationLineConverter
	implements
	JMHResultLineConverter<WarmupMeasure> {

	@Override
	public WarmupMeasure converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		WarmupMeasure result = new WarmupMeasure();
		result.setIndex(Integer.valueOf(matcher.group(1)));
		result.setScore(matcher.group(5));
		result.setScoreError(matcher.group(5));
		result.setUnit(matcher.group(6));
		return result;
	}

	private String regex() {
		return "# Warmup Iteration"
			+ "[ |\\t]+"
			+ "([0-9]+)"
			+ ":"
			+ "[ |\\t]+"
			+ "(([0-9]+[,|\\.][0-9]+)..\\(([0-9]+[,|\\.][0-9]+)%\\)[ |\\t]+){0,1}"
			+ "([0-9]+[,|\\.][0-9]+)"
			+ "[ |\\t]+"
			+ "((ops/ns)|(ns/op))";
	}
}
