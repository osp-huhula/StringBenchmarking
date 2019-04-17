package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

public class JMHVersionLineConverterTest {

	private JMHVersionLineConverter converter = new JMHVersionLineConverter();

	@Test
	public void converter() {
		Double result
			= converter.converter("# JMH 1.16 (released 887 days ago, please consider updating!)");
		Assert.assertEquals(Double.valueOf("1.16"), result);
	}
}
