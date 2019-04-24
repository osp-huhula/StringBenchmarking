package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.commons.exception.JMHRuntimeException;
import stringbenchmarking.enums.BenchmarkModeEnum;
import stringbenchmarking.result.beans.Warmup;

public final class WarmupLineConverter
	implements
	JMHResultLineConverter<Warmup> {

	private final BenchmarkModeEnum mode;

	public WarmupLineConverter(
		BenchmarkModeEnum mode) {
		super();
		this.mode = mode;
	}

	@Override
	public Warmup converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		Warmup result = new Warmup();
		result.setIterations(Integer.valueOf(matcher.group(1)));
		result.setUnit(matcher.group(2));
		return result;
	}

	private String regex() {
		switch (mode) {
			case THROUGHPUT:
				return "# Warmup Iteration   ([0-9]+): ([0-9]+,[0-9]+) ns/op";
			case AVERAGE_TIME:
				return "# Warmup: ([0-9]+) iterations, ([0-9]+) s each";
			default:
				throw new JMHRuntimeException("not implemented : " + mode);
		}
	}

}
