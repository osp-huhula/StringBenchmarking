package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.Iteration;

public class IterationLineConverterTest {

	private IterationLineConverter converter = new IterationLineConverter();

	@Test
	public void converter() {
		Iteration result = converter.converter("Iteration   1: 4550,198 ns/op");
		Assert.assertEquals(Integer.valueOf("1"), result.getIndex());
		Assert.assertEquals(Double.valueOf("4550.198"), result.getResult());
	}
}
