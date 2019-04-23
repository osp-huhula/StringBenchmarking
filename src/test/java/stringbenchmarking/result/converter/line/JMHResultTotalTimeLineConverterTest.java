package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;


public class JMHResultTotalTimeLineConverterTest {

	private JMHResultTotalTimeLineConverter converter = new JMHResultTotalTimeLineConverter();

	@Test
	public void converter() {
		String result = converter.converter("# Run complete. Total time: 00:03:46");
		Assert.assertEquals("00:03:46", result);
	}
	
}
