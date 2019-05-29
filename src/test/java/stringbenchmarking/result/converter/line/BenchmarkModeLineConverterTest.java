package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.enums.BenchmarkModeEnum;

public class BenchmarkModeLineConverterTest {

	private BenchmarkModeLineConverter converter = new BenchmarkModeLineConverter();

	@Test
	public void converterTHROUGHPUT() {
		BenchmarkModeEnum result = converter.converter("# Benchmark mode: Throughput, ops/time");
		Assert.assertEquals(BenchmarkModeEnum.THROUGHPUT, result);
	}
	
	@Test
	public void converterAVERAGE_TIME() {
		BenchmarkModeEnum result = converter.converter("# Benchmark mode: Average time, time/op");
		Assert.assertEquals(BenchmarkModeEnum.AVERAGE_TIME, result);
	}
	
	@Test
	public void converterSAMPLING_TIME() {
		BenchmarkModeEnum result = converter.converter("# Benchmark mode: Sampling time");
		Assert.assertEquals(BenchmarkModeEnum.SAMPLING_TIME, result);
	}
}
