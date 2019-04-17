package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.enums.BenchmarkModeEnum;

public class BenchmarkModeLineConverterTest {

	private BenchmarkModeLineConverter converter = new BenchmarkModeLineConverter();

	@Test
	public void converter() {
		BenchmarkModeEnum result = converter.converter("# Benchmark mode: Throughput, ops/time");
		Assert.assertEquals(BenchmarkModeEnum.THROUGHPUT, result);
	}
}
