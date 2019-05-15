package stringbenchmarking.result.converter.line.average;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.BenchmarkResultOne;


public class BenchmarkResultOneLineConverterTest {
	
	private BenchmarkResultOneLineConverter converter = new BenchmarkResultOneLineConverter();

	@Test
	public void converter() {
		BenchmarkResultOne result = converter.converter("  0,057 ops/ns");
		Assert.assertEquals("0,057", result.getScore());
		Assert.assertEquals("ops/ns", result.getUnit());
	}
}
