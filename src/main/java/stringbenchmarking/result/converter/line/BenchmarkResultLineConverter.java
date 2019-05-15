package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.JMHBenchmarkResult;

public final class BenchmarkResultLineConverter
	implements
	JMHResultLineConverter<JMHBenchmarkResult> {

	@Override
	public JMHBenchmarkResult converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		JMHBenchmarkResult result = new JMHBenchmarkResult();
		result.setName(matcher.group(1));
		result.setType(matcher.group(2));
		result.setCount(matcher.group(5));
		result.setScore(matcher.group(6));
		result.setError(matcher.group(9));
		result.setUnits(matcher.group(10));
		return result;
	}
	
	private String regex() {
		return "([a-zA-Z0-9\\.]+)"
			+ "[ |\\t]+"
			+ "((avgt)|(thrpt))"
			+ "[ |\\t]+"
			+ "([0-9]*)"
			+ "[ |\\t]+"
			+ "([0-9]+,[0-9]+)"
			+ "(([ |\\t]*[�|.]{1}[ |\\t]*)([0-9]+,[0-9]+)){0,1}"
			+ "[ |\\t]+"
			+ "((ns/op)|(ops/ns))";
	}
}
