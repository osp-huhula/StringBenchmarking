package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

public class BenchmarkActionLineConverterTest {

	private BenchmarkActionLineConverter converter = new BenchmarkActionLineConverter();

	@Test
	public void converter() {
		String result = converter
			.converter("# Benchmark: stringbenchmarking.StringBenchmarkWithConcate.example");
		Assert.assertEquals("stringbenchmarking.StringBenchmarkWithConcate.example", result);
	}
}
