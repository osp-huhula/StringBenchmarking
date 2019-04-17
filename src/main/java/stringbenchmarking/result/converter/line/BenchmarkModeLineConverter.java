package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.enums.BenchmarkModeEnum;

public final class BenchmarkModeLineConverter
	implements
	JMHResultLineConverter<BenchmarkModeEnum> {

	@Override
	public BenchmarkModeEnum converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		return BenchmarkModeEnum.fromValue(matcher.group(1));
	}

	private String regex() {
		return "# Benchmark mode: ([a-zA-Z ]+), ops/time";
	}
}
