package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.Fork;

public class ForkLineConverterTest {

	private ForkLineConverter converter = new ForkLineConverter();

	@Test
	public void converter() {
		Fork result = converter.converter("# Fork: 1 of 10");
		Assert.assertEquals(Integer.valueOf("1"), result.getIndex());
		Assert.assertEquals(Integer.valueOf("10"), result.getTotal());
	}
}
