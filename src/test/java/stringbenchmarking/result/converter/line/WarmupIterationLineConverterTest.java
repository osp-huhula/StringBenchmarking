package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.WarmupMeasure;

public class WarmupIterationLineConverterTest {

	private WarmupIterationLineConverter converter = new WarmupIterationLineConverter();

	@Test
	public void converter() {
		WarmupMeasure result = converter.converter("# Warmup Iteration   1: 0,100 ops/ns");
		Assert.assertEquals(Integer.valueOf("1"), result.getIndex());
		Assert.assertEquals("0,100", result.getResult());
		Assert.assertEquals(Double.valueOf("0.100"), result.getResultAsDouble(), 0);
	}

	@Test
	public void converterAveragetime() {
		WarmupMeasure result = converter.converter("# Warmup Iteration   1: 2,647 ns/op");
		Assert.assertEquals(Integer.valueOf("1"), result.getIndex());
		Assert.assertEquals("2,647", result.getResult());
		Assert.assertEquals(Double.valueOf("2.647"), result.getResultAsDouble(), 0);
	}
	
}
