package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.WarmupIteration;

public class WarmupIterationLineConverterTest {

	private WarmupIterationLineConverter converter = new WarmupIterationLineConverter();

	@Test
	public void converter() {
		WarmupIteration result = converter.converter("# Warmup Iteration   1: 44363,871 ns/op");
		Assert.assertEquals(Integer.valueOf("1"), result.getIndex());
		Assert.assertEquals(Double.valueOf("44363.871"), result.getResult());
	}
}
