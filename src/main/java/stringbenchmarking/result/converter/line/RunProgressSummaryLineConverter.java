package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.RunProgressSummary;

public class RunProgressSummaryLineConverter
	implements
	JMHResultLineConverter<RunProgressSummary> {

	@Override
	public RunProgressSummary converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		RunProgressSummary result = new RunProgressSummary();
		result.setPeComplete(matcher.group(1));
		result.setEta(matcher.group(2));
		return result;
	}

	private String regex() {
		return "# Run progress: ([0-9]+,[0-9]+)% complete, ETA ([0-9]{2}:[0-9]{2}:[0-9]{2})";
	}
}
