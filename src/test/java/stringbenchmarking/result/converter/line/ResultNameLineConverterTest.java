package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

public class ResultNameLineConverterTest {

	private ResultNameLineConverter converter = new ResultNameLineConverter();

	@Test
	public void converter() {
		String result = converter.converter("Result \"cancatenateWith_long_string_x10\":");
		Assert.assertEquals("cancatenateWith_long_string_x10", result);
	}
}
