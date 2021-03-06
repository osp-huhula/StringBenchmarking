package stringbenchmarking.result.converter.line.average;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.ResultForkAverageStatistics;

public class ResultStatisticsLineConverter {

	public ResultForkAverageStatistics converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content.replaceAll("[^\\x20-\\x7e]", ""));
		ResultForkAverageStatistics result = new ResultForkAverageStatistics();
		result.setMin(matcher.group(1));
		result.setAverage(matcher.group(2));
		result.setMax(matcher.group(3));
		result.setStdev(matcher.group(4));
		return result;
	}

	private String regex() {
		return "  \\(min, avg, max\\) = \\(([0-9]+,[0-9]+), ([0-9]+,[0-9]+), ([0-9]+,[0-9]+)\\), stdev = ([0-9]+,[0-9]+)";
	}
}
