package stringbenchmarking.result.converter.line.average;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.ResultForkAverageInfo;


public class ResultAverageLineConverterTest {

	private ResultAverageLineConverter converter = new ResultAverageLineConverter();

	@Test
	public void converter01() {
		ResultForkAverageInfo result = converter.converter("  3,291 �(99.9%) 3,024 ns/op [Average]");
		Assert.assertEquals("3,291", result.getScore());
		Assert.assertEquals("99.9", result.getPercent());
		Assert.assertEquals("3,024", result.getError());
		Assert.assertEquals("ns/op", result.getUnit());
	}
	
	@Test
	public void converter02() {
		ResultForkAverageInfo result = converter.converter("  0,135 �(99.9%) 0,174 ops/ns [Average]");
		Assert.assertEquals("0,135", result.getScore());
		Assert.assertEquals("99.9", result.getPercent());
		Assert.assertEquals("0,174", result.getError());
		Assert.assertEquals("ops/ns", result.getUnit());
	}
}
