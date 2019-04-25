package stringbenchmarking.result;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import stringbenchmarking.commons.ResourceReader;
import stringbenchmarking.commons.exception.UnexpectedEOF;
import stringbenchmarking.commons.zuz.ZuzObjects;
import stringbenchmarking.result.beans.JMHResult;
import stringbenchmarking.result.converter.JMHOutputResultConverterDefault;



@RunWith(Parameterized.class)
public class JMHOutputResultConverterDefaultPTest {

	
	@Parameters(name= "{index}: converting file[{0}]={1}")
	public static Iterable<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
//		data.add(new Object[] {new File("benchmark_mode-Throughput-single")});
//		data.add(new Object[] {new File("benchmark_mode-AverageTime-single")});
//		data.add(new Object[] {new File("benchmark_mode-SampleTime-single")});
//		data.add(new Object[] {new File("benchmark_mode-SingleShotTime-single")});
//		data.add(new Object[] {new File("benchmark_mode-All-single")});
//		data.add(new Object[] {new File("benchmark_mode-Throughput-multiple")});
		
//		data.add(new Object[] {new File("benchmark_mode-AverageTime-multiple")});
		
//		data.add(new Object[] {new File("benchmark_mode-SampleTime-multiple")});
//		data.add(new Object[] {new File("benchmark_mode-SingleShotTime-multiple")});
//		data.add(new Object[] {new File("benchmark_mode-All-multiple")});
//		data.add(new Object[] {new File("benchmark_mode-multiple-different")});
		data.add(new Object[] {new File("JMH-ouput-20190424.2335")});
		return data;
	}
	
	private final ResourceReader reader = new ResourceReader();
	private final JMHOutputResultConverterDefault converter = new JMHOutputResultConverterDefault();

	private File file;

	public JMHOutputResultConverterDefaultPTest(
		File file) {
		super();
		this.file = file;
	}

	@Test
	public void converter()
		throws UnexpectedEOF {
		String content = reader.readFile("//result/" + file.getName() + ".log");
		String expectedContent = reader.readFile("expected/" + file.getName());
		JMHResult result = converter.converter(content);
		String actual = toString(result);
		Assert.assertEquals(expectedContent, actual);
	}

	private String toString(
		JMHResult result) {
		ZuzObjects.changeDefaultStyle(ToStringStyle.SHORT_PREFIX_STYLE);
		return ZuzObjects.reflectionToString(result);
	}
	
}
