package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

public class VMOptionsLineConverterTest {

	private VMOptionsLineConverter converter = new VMOptionsLineConverter();

	@Test
	public void converter() {
		String result = converter.converter("# VM options: <none>");
		Assert.assertEquals("<none>", result);
	}
}
