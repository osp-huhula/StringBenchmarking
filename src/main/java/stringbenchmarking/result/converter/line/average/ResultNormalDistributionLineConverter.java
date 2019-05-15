package stringbenchmarking.result.converter.line.average;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.ResultForkDistribution;

public class ResultNormalDistributionLineConverter {

	public ResultForkDistribution converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content.replaceAll("[^\\x20-\\x7e]", ""));
		ResultForkDistribution result = new ResultForkDistribution();
		result.setPeConfidenceInterval(matcher.group(1));
		result.setMin(matcher.group(2));
		result.setMax(matcher.group(5));
		return result;
	}

	private String regex() {
		return "  CI \\(([0-9]+.[0-9]+)%\\): \\["+"(([0-9]+,[0-9]+)|(\\? 0))"+", ([0-9]+,[0-9]+)\\] \\(assumes normal distribution\\)";
	}
}
