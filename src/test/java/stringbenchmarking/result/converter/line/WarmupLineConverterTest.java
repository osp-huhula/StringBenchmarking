package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.enums.BenchmarkModeEnum;
import stringbenchmarking.result.beans.Warmup;

public class WarmupLineConverterTest {

	@Test
	public void converterThroughput() {
		Warmup result = new WarmupLineConverter(BenchmarkModeEnum.THROUGHPUT).converter("# Warmup Iteration   1: 2,647 ns/op");
		Assert.assertEquals(Integer.valueOf(1), result.getIterations());
		Assert.assertEquals("2,647", result.getUnit());
	}
	
	@Test
	public void converterAveragetime() {
		Warmup result = new WarmupLineConverter(BenchmarkModeEnum.AVERAGE_TIME).converter("# Warmup: 10 iterations, 5 s each");
		Assert.assertEquals(Integer.valueOf(10), result.getIterations());
		Assert.assertEquals("5", result.getUnit());
	}
}
