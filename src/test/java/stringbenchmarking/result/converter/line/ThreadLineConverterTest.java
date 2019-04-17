package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

public class ThreadLineConverterTest {

	private ThreadLineConverter converter = new ThreadLineConverter();

	@Test
	public void converter() {
		Integer result = converter.converter("# Threads: 1 thread, will synchronize iterations");
		Assert.assertEquals(Integer.valueOf("1"), result);
	}
}
