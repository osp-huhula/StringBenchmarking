package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.WarmUp;

public class WarmupLineConverterTest {

	private WarmupLineConverter converter = new WarmupLineConverter();

	@Test
	public void converter() {
		WarmUp result = converter.converter("# Warmup: 10 iterations, 5 s each");
		Assert.assertEquals(Integer.valueOf(10), result.getIterations());
		Assert.assertEquals(Integer.valueOf(5), result.getSeconds());
	}
}
