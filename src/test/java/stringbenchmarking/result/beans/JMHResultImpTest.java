package stringbenchmarking.result.beans;

import org.junit.Ignore;
import org.junit.Test;

import stringbenchmarking.DefaultEXHVerifier;
import stringbenchmarking.commons.exception.UnexpectedEOF;


public class JMHResultImpTest {

	@Test
	public void testEXH() {
		DefaultEXHVerifier.verifyReflection(JMHResultImp.class);
	}
	

	@Ignore
	@Test
	public void converter()
		throws UnexpectedEOF {
//		String content = reader.readFile("//result/" + file.getName() + ".log");
//		String expectedContent = reader.readFile("expected/" + file.getName());
//		JMHResult result = converter.converter(content);
//		Assert.assertTrue(result instanceof JMHResultImp);
//		String sResult = asStringSPS(result);
//		String actual = toString(result);
	}

}
