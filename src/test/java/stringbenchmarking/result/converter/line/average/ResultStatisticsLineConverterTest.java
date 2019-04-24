package stringbenchmarking.result.converter.line.average;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.ResultStatistics;


public class ResultStatisticsLineConverterTest {

	private ResultStatisticsLineConverter converter = new ResultStatisticsLineConverter();

	@Test
	public void converter() {
		ResultStatistics result = converter.converter("  (min, avg, max) = (2,639, 3,291, 3,679), stdev = 0,468");
		Assert.assertEquals("2,639", result.getMin());
		Assert.assertEquals("3,291", result.getAverage());
		Assert.assertEquals("3,679", result.getMax());
		Assert.assertEquals("0,468", result.getStdev());
	}
}
