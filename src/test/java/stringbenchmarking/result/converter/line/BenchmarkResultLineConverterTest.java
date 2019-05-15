package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.JMHBenchmarkResult;

public class BenchmarkResultLineConverterTest {

	private BenchmarkResultLineConverter converter = new BenchmarkResultLineConverter();

	@Test
	public void converter01() {
		JMHBenchmarkResult result = converter.converter(
			"StringBenchmarkWithConcate.example01        avgt    4  3,291 �  3,024  ns/op");
		Assert.assertEquals("StringBenchmarkWithConcate.example01", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("4", result.getCount());
		Assert.assertEquals("3,291", result.getScore());
		Assert.assertEquals("3,024", result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}

	@Test
	public void converter02() {
		JMHBenchmarkResult result = converter.converter(
			"StringBenchmarkWithConcate.example02        avgt    4  9,704 � 22,795  ns/op");
		Assert.assertEquals("StringBenchmarkWithConcate.example02", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("4", result.getCount());
		Assert.assertEquals("9,704", result.getScore());
		Assert.assertEquals("22,795", result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}

	@Test
	public void converter03() {
		JMHBenchmarkResult result = converter.converter(
			"StringBenchmarkWithPlus.example01           avgt    4  4,197 �  8,296  ns/op");
		Assert.assertEquals("StringBenchmarkWithPlus.example01", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("4", result.getCount());
		Assert.assertEquals("4,197", result.getScore());
		Assert.assertEquals("8,296", result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}

	@Test
	public void converter04() {
		JMHBenchmarkResult result = converter.converter(
			"StringBenchmarkWithPlus.example02           avgt    4  2,877 �  2,489  ns/op");
		Assert.assertEquals("StringBenchmarkWithPlus.example02", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("4", result.getCount());
		Assert.assertEquals("2,877", result.getScore());
		Assert.assertEquals("2,489", result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}

	@Test
	public void converter05() {
		JMHBenchmarkResult result = converter.converter(
			"StringBenchmarkWithStringBuffer.example01   avgt    4  3,437 �  1,917  ns/op");
		Assert.assertEquals("StringBenchmarkWithStringBuffer.example01", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("4", result.getCount());
		Assert.assertEquals("3,437", result.getScore());
		Assert.assertEquals("1,917", result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}

	@Test
	public void converter06() {
		JMHBenchmarkResult result = converter.converter(
			"StringBenchmarkWithStringBuffer.example02   avgt    4  3,747 �  3,556  ns/op");
		Assert.assertEquals("StringBenchmarkWithStringBuffer.example02", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("4", result.getCount());
		Assert.assertEquals("3,747", result.getScore());
		Assert.assertEquals("3,556", result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}

	@Test
	public void converter07() {
		JMHBenchmarkResult result = converter.converter(
			"StringBenchmarkWithStringBuilder.example01  avgt    4  3,429 �  2,424  ns/op");
		Assert.assertEquals("StringBenchmarkWithStringBuilder.example01", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("4", result.getCount());
		Assert.assertEquals("3,429", result.getScore());
		Assert.assertEquals("2,424", result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}

	@Test
	public void converter08() {
		JMHBenchmarkResult result = converter.converter(
			"StringBenchmarkWithStringBuilder.example02  avgt    4  3,520 �  4,623  ns/op");
		Assert.assertEquals("StringBenchmarkWithStringBuilder.example02", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("4", result.getCount());
		Assert.assertEquals("3,520", result.getScore());
		Assert.assertEquals("4,623", result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}
	
	@Test
	public void converter09() {
		JMHBenchmarkResult result = converter.converter(
				"StringBenchmarkWithConcate.example          avgt    2  2,743          ns/op");
		Assert.assertEquals("StringBenchmarkWithConcate.example", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("2", result.getCount());
		Assert.assertEquals("2,743", result.getScore());
		Assert.assertNull(result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}
	
	@Test
	public void converter10() {
		JMHBenchmarkResult result = converter.converter(
				"StringBenchmarkWithConcate.example        avgt       3,384          ns/op");
		Assert.assertEquals("StringBenchmarkWithConcate.example", result.getName());
		Assert.assertEquals("avgt", result.getType());
		Assert.assertEquals("", result.getCount());
		Assert.assertEquals("3,384", result.getScore());
		Assert.assertNull(result.getError());
		Assert.assertEquals("ns/op", result.getUnits());
	}
}
