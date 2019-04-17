package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.Measurement;

public class MeasurementLineConverterTest {

	private MeasurementLineConverter converter = new MeasurementLineConverter();

	@Test
	public void converter() {
		Measurement result = converter.converter("# Measurement: 10 iterations, 5 s each");
		Assert.assertEquals(Integer.valueOf(10), result.getIterations());
		Assert.assertEquals(Integer.valueOf(5), result.getSeconds());
	}
}
