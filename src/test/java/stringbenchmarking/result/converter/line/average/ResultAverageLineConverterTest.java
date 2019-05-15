package stringbenchmarking.result.converter.line.average;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.ResultForkAverageInfo;


public class ResultAverageLineConverterTest {

	private ResultAverageLineConverter converter = new ResultAverageLineConverter();

	@Test
	public void converter() {
		ResultForkAverageInfo result = converter.converter("  3,291 �(99.9%) 3,024 ns/op [Average]");
		Assert.assertEquals("3,291", result.getScore());
		Assert.assertEquals("99.9", result.getPercent());
		Assert.assertEquals("3,024", result.getError());
		Assert.assertEquals("ns/op", result.getUnit());
	}
}
