package stringbenchmarking.result.converter.line;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.result.beans.VirtualMachine;

public class VMVersionLineConverterTest {

	private VMVersionLineConverter converter = new VMVersionLineConverter();

	@Test
	public void converter() {
		VirtualMachine result = converter.converter("# VM version: JDK 1.6.0_45, VM 20.45-b01");
		Assert.assertEquals("1.6.0_45", result.getJdkVersion());
		Assert.assertEquals("20.45-b01", result.getVmVersion());
	}
}
