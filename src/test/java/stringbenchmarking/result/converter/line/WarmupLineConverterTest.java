package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.Warmup;

public class WarmupLineConverterTest {
	
	private WarmupLineConverter converter = new WarmupLineConverter();

	@Test
	public void converterThroughput01() {
		Warmup result = converter.converter("# Warmup Iteration   1: 2,647 ns/op");
		Assert.assertEquals(Integer.valueOf(1), result.getIterations());
		Assert.assertEquals("2,647", result.getUnit());
	}
	
	@Test
	public void converterThroughput02() {
		Warmup result = converter.converter("# Warmup: 1 iterations, 1 s each");
		Assert.assertEquals(Integer.valueOf(1), result.getIterations());
		Assert.assertEquals("1", result.getUnit());
	}
	
	@Test
	public void converterAveragetime() {
		Warmup result = converter.converter("# Warmup: 10 iterations, 5 s each");
		Assert.assertEquals(Integer.valueOf(10), result.getIterations());
		Assert.assertEquals("5", result.getUnit());
	}
	
}
