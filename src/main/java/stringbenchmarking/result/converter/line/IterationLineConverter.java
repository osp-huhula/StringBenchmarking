package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.IterationMeasure;

public final class IterationLineConverter
	implements
	JMHResultLineConverter<IterationMeasure> {

	@Override
	public IterationMeasure converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		IterationMeasure result = new IterationMeasure();
		result.setIndex(Integer.valueOf(matcher.group(1)));
		result.setResult(matcher.group(2));
		return result;
	}

	private String regex() {
		return "Iteration[ ]+([0-9]+): ([0-9]+[,|\\.][0-9]+) ((ops/ns)|(ns/op))";
	}
}
