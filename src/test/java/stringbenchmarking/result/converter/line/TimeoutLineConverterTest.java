package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

public class TimeoutLineConverterTest {

	private TimeoutLineConverter converter = new TimeoutLineConverter();

	@Test
	public void converter() {
		Integer result = converter.converter("# Timeout: 10 min per iteration");
		Assert.assertEquals(Integer.valueOf("10"), result);
	}
}
