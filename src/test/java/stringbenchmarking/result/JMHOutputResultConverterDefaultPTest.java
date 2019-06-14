package stringbenchmarking.result;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import stringbenchmarking.JUnitFileReader;
import stringbenchmarking.commons.DateProvider;
import stringbenchmarking.commons.exception.UnexpectedEOF;
import stringbenchmarking.commons.zuz.ZuzObjects;
import stringbenchmarking.result.beans.JMHResult;
import stringbenchmarking.result.converter.JMHOutputResultConverterDefault;


@RunWith(Parameterized.class)
public class JMHOutputResultConverterDefaultPTest {

	@Parameters(name= "{index}: converting file[{0}]={1}")
	public static Iterable<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		//single
		data.add(new Object[] {new File("benchmark_mode-Throughput-single")});
		//data.add(new Object[] {new File("benchmark_mode-AverageTime-single")});
//		data.add(new Object[] {new File("benchmark_mode-SampleTime-single")});
//		data.add(new Object[] {new File("benchmark_mode-SingleShotTime-single")});
//		data.add(new Object[] {new File("benchmark_mode-All-single")});
		//multiples
		//data.add(new Object[] {new File("benchmark_mode-Throughput-multiple")});
		//data.add(new Object[] {new File("benchmark_mode-AverageTime-multiple")});
//		data.add(new Object[] {new File("benchmark_mode-SampleTime-multiple")});
//		data.add(new Object[] {new File("benchmark_mode-SingleShotTime-multiple")});
//		data.add(new Object[] {new File("benchmark_mode-All-multiple")});
//		data.add(new Object[] {new File("benchmark_mode-multiple-different")});
		//data.add(new Object[] {new File("JMH-ouput-20190424.2335")});
		return data;
	}

	private final DateProvider dateProvider = Mockito.mock(DateProvider.class);
	private final JMHOutputResultConverterDefault converter = new JMHOutputResultConverterDefault(dateProvider);

	private File file;

	public JMHOutputResultConverterDefaultPTest(
		File file) {
		super();
		this.file = file;
	}

	@Before
	public void setUp() {
		Mockito.when(dateProvider.nowAsString()).thenReturn("20010101.000000000", "29991230.235959000");
	}

	@Test
	public void converter()
		throws UnexpectedEOF {
		String content = null;
		readFile("\\result/" + file.getName() + ".log");
		readFile("/result/" + file.getName() + ".log");
		readFile("result/" + file.getName() + ".log");
		String expectedContent = reader().readFile("expected/" + file.getName());
		JMHResult result = converter.converter(content);
		String actual = asString(result);
		Assert.assertEquals(expectedContent, actual);
		Mockito.verify(dateProvider, Mockito.times(2)).nowAsString();
	}

	private String readFile(
		String path) {
		String result = null;
		try { result = reader().readFile(path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readFile(getClass(), path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readFile(Thread.currentThread(), path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readFileAsStream(path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readFileAsStream(getClass(), path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readFileAsStream(Thread.currentThread(), path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}


		try { result = reader().readFileAsStream(ClassLoader.getSystemClassLoader(), path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readFile(ClassLoader.getSystemClassLoader(), path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readResource(path, ClassLoader.getSystemResource(path));throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readResource(path, ClassLoader.getSystemResourceAsStream(path));throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readResource(path, JMHOutputResultConverterDefaultPTest.class.getClassLoader().getResource(path));throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		try { result = reader().readResource(path, JMHOutputResultConverterDefaultPTest.class.getClassLoader().getResourceAsStream(path));throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}

//		try { result = reader().readResource(getClass(), path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
//		try { result = reader().readResourceAsStream(getClass(), path);throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
//		try { result = reader().readResource(path, JMHOutputResultConverterDefaultPTest.class.getResource(path));throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
//		try { result = reader().readResource(path, JMHOutputResultConverterDefaultPTest.class.getResourceAsStream(path));throw new IllegalArgumentException("worked");} catch (Exception e) {print(e);}
		return result;
	}

	private JUnitFileReader reader() {
		return new JUnitFileReader();
	}

	private void print(
		Exception e) {
		if(!"worked".equals(e.getMessage())) {
			List<StackTraceElement> asList = Arrays.asList(e.getStackTrace());
			for (StackTraceElement stackTraceElement : asList) {
				if(stackTraceElement.getMethodName().equals("converter")) {
					System.err.println(e.getStackTrace()[asList.indexOf(stackTraceElement)-1] + e.getMessage());
					return;
				}
			}
		} else {
			System.err.println(e.getStackTrace()[0] + e.getMessage());
		}
	}

	private String asString(
		JMHResult result) {
		ZuzObjects.changeDefaultStyle(ToStringStyle.SHORT_PREFIX_STYLE);
		return ZuzObjects.reflectionToString(result);
	}

}
