package stringbenchmarking.result.converter.line.average;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.ResultForkDistribution;


public class ResultNormalDistributionLineConverterTest {

	private ResultNormalDistributionLineConverter converter = new ResultNormalDistributionLineConverter();

	@Test
	public void converter01() {
		ResultForkDistribution result = converter.converter("  CI (99.9%): [0,267, 6,315] (assumes normal distribution)");
		Assert.assertEquals("99.9", result.getPeConfidenceInterval());
		Assert.assertEquals("0,267", result.getMin());
		Assert.assertEquals("6,315", result.getMax());
	}
	
	@Test
	public void converter02() {
		ResultForkDistribution result = converter.converter("  CI (99.9%): [? 0, 32,499] (assumes normal distribution)");
		Assert.assertEquals("?", result.getPeConfidenceInterval());
		Assert.assertEquals("0,267", result.getMin());
		Assert.assertEquals("6,315", result.getMax());
	}
}
