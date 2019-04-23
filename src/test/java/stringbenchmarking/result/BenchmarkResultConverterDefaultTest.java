package stringbenchmarking.result;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import stringbenchmarking.commons.FileReader;
import stringbenchmarking.result.beans.JMHResult;
import stringbenchmarking.result.beans.JMHResultImp;
import stringbenchmarking.result.converter.BenchmarkResultConverterDefault;



@RunWith(Parameterized.class)
public class BenchmarkResultConverterDefaultTest {

	
	@Parameters(name= "{index}: converting file[{0}]={1}")
	public static Iterable<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
//		data.add(new Object[] {new File("benchmark_mode-Throughput-single.log"), new JMHResultImp()});
//		data.add(new Object[] {new File("benchmark_mode-AverageTime-single.log"), new JMHResultImp()});
//		data.add(new Object[] {new File("benchmark_mode-SampleTime-single.log"), new JMHResultImp()});
//		data.add(new Object[] {new File("benchmark_mode-SingleShotTime-single.log"), new JMHResultImp()});
//		data.add(new Object[] {new File("benchmark_mode-All-single.log"), new JMHResultImp()});
//		data.add(new Object[] {new File("benchmark_mode-Throughput-multiple.log"), new JMHResultImp()});
		data.add(new Object[] {new File("benchmark_mode-AverageTime-multiple.log"), new JMHResultImp()});
//		data.add(new Object[] {new File("benchmark_mode-SampleTime-multiple.log"), new JMHResultImp()});
//		data.add(new Object[] {new File("benchmark_mode-SingleShotTime-multiple.log"), new JMHResultImp()});
//		data.add(new Object[] {new File("benchmark_mode-All-multiple.log"), new JMHResultImp()});
//		data.add(new Object[] {new File("benchmark_mode-multiple-different.log"), new JMHResultImp()});
		return data;
	}
	
	private final FileReader reader = new FileReader();
	private final BenchmarkResultConverterDefault converter = new BenchmarkResultConverterDefault();

    private File file;
    private JMHResult expected;
    
	public BenchmarkResultConverterDefaultTest(
		File file,
		JMHResult expected) {
		super();
		this.file = file;
		this.expected = expected;
	}

	@Test
	public void test() {
		String content = reader.readFile("result/".concat(file.getName()));
		System.out.println(content);
		JMHResult result = converter.converter(content);
		System.err.println(result.toString());
//		Assert.assertEquals(expected, result);
		fail("Not yet implemented");
	}
}
