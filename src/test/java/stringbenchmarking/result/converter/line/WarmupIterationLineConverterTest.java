package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.WarmupMeasure;

public class WarmupIterationLineConverterTest {

	private WarmupIterationLineConverter converter = new WarmupIterationLineConverter();

	@Test
	public void converter01() {
		WarmupMeasure result = converter.converter("# Warmup Iteration   1: 0,100 ops/ns");
		Assert.assertEquals(Integer.valueOf("1"), result.getIndex());
		Assert.assertEquals("0,100", result.getScore());
		Assert.assertEquals(Double.valueOf("0.100"), result.getScoreAsDouble(), 0);
		Assert.assertEquals("ops/ns", result.getUnit());
	}

	@Test
	public void converter02() {
		WarmupMeasure result = converter.converter("# Warmup Iteration   1: 2,647 ns/op");
		Assert.assertEquals(Integer.valueOf("1"), result.getIndex());
		Assert.assertEquals("2,647", result.getScore());
		Assert.assertEquals(Double.valueOf("2.647"), result.getScoreAsDouble(), 0);
		Assert.assertEquals("ns/op", result.getUnit());
	}
	
	@Test
	public void converter03() {
		WarmupMeasure result = converter.converter("# Warmup Iteration   1: 85,819 �(99.9%) 37,254 ns/op");
		Assert.assertEquals(Integer.valueOf("1"), result.getIndex());
		Assert.assertEquals("37,254", result.getScore());
		Assert.assertEquals(Double.valueOf("37.254"), result.getScoreAsDouble(), 0);
		Assert.assertEquals("ns/op", result.getUnit());
	}
	
}
