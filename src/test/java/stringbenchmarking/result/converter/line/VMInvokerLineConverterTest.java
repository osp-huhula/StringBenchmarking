package stringbenchmarking.result.converter.line;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;


public class VMInvokerLineConverterTest {

	private VMInvokerLineConverter converter = new VMInvokerLineConverter();

	@Test
	public void converter() {
		File result = converter.converter("# VM invoker: C:\\.app\\JAVA\\jdk1.6.0_45\\jre\\bin\\java.exe");
		Assert.assertEquals("C:\\.app\\JAVA\\jdk1.6.0_45\\jre\\bin\\java.exe", result.getPath());
	}
}
