package stringbenchmarking.result.converter.line.average;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.BenchmarkResultOne;

public class BenchmarkResultOneLineConverter {

	public BenchmarkResultOne converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content.replaceAll("[^\\x20-\\x7e]", ""));
		BenchmarkResultOne result = new BenchmarkResultOne();
		result.setScore(matcher.group(1));
		result.setUnit(matcher.group(2));
		return result;
	}

	private String regex() {
		return "  ([0-9]+,[0-9]+) (ns/op)";
	}
}
