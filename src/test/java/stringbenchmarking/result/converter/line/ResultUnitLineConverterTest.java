package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

public class ResultUnitLineConverterTest {

	private ResultUnitLineConverter converter = new ResultUnitLineConverter();

	@Test
	public void converter() {
		String result = converter.converter("  37280,398 ns/op");
		Assert.assertEquals("37280,398", result);
	}
}
