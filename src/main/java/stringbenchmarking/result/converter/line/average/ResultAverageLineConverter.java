package stringbenchmarking.result.converter.line.average;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.ResultForkAverageInfo;

public class ResultAverageLineConverter {

	public ResultForkAverageInfo converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content.replaceAll("[^\\x20-\\x7e]", ""));
		ResultForkAverageInfo result = new ResultForkAverageInfo();
		result.setScore(matcher.group(1));
		result.setPercent(matcher.group(2));
		result.setError(matcher.group(3));
		result.setUnit(matcher.group(4));
		return result;
	}

	private String regex() {
		return "  ([0-9]+,[0-9]+) "
			+ "\\(([0-9]+.[0-9]+)%\\) "
			+ "([0-9]+,[0-9]+) "
			+ "((ns/op)|(ops/ns)) "
			+ "\\[Average\\]";
	}
}
