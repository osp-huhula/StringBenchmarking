package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.RunProgressSummary;

public class RunProgressSummaryLineConverterTest {

	private RunProgressSummaryLineConverter converter = new RunProgressSummaryLineConverter();

	@Test
	public void converter() {
		RunProgressSummary result = converter.converter("# Run progress: 0,00% complete, ETA 00:00:24");
		Assert.assertEquals("0,00", result.getPeComplete());
		Assert.assertEquals("00:00:24", result.getEta());
	}
}
