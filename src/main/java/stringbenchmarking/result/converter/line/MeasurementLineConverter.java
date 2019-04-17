package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.Measurement;

public final class MeasurementLineConverter
	implements
	JMHResultLineConverter<Measurement> {

	@Override
	public Measurement converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		Measurement result = new Measurement();
		result.setIterations(Integer.valueOf(matcher.group(1)));
		result.setSeconds(Integer.valueOf(matcher.group(2)));
		return result;
	}

	private String regex() {
		return "# Measurement: ([0-9]+) iterations, ([0-9]+) s each";
	}
}
