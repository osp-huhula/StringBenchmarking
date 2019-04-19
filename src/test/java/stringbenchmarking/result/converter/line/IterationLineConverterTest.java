package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.IterationMeasure;

public class IterationLineConverterTest {

	private IterationLineConverter converter = new IterationLineConverter();

	@Test
	public void converter() {
		IterationMeasure result = converter.converter("Iteration   1: 0,350 ops/ns");
		Assert.assertEquals(Integer.valueOf("1"), result.getIndex());
		Assert.assertEquals("0,350", result.getResult());
		Assert.assertEquals(Double.valueOf("0.350"), result.getResultAsDouble());
	}
}
