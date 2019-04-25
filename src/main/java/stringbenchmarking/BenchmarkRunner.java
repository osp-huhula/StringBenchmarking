package stringbenchmarking;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import stringbenchmarking.commons.exception.JMHRuntimeException;
import stringbenchmarking.commons.exception.UnexpectedEOF;
import stringbenchmarking.commons.zuz.ZuzFiles;
import stringbenchmarking.commons.zuz.ZuzSerializer;
import stringbenchmarking.commons.zuz.Zyz;
import stringbenchmarking.result.beans.JMHResult;
import stringbenchmarking.result.converter.JMHOutputResultConverter;
import stringbenchmarking.result.converter.JMHOutputResultConverterDefault;

public class BenchmarkRunner {
	
	private static final JMHOutputResultConverter CONVERTER = new JMHOutputResultConverterDefault();

	public static void main(
		String[] args)
		throws Exception {
		List<String> parameters = Arrays.asList(args);
		if(!parameters.contains("-o")) {
			throw new JMHRuntimeException("Parameter -o is required.");
		}
//		Options opt = opt();
//		new org.openjdk.jmh.runner.Runner(opt);
		org.openjdk.jmh.Main.main(args);
		sendResultOutputFile(new File(parameters.get(parameters.indexOf("-o") 		+ 1)));
		sendResultJSONFile(new File(parameters.get(parameters.indexOf("-rff") 		+ 1)));
	}

	private static void sendResultOutputFile(
		File file) throws UnexpectedEOF {
		ZuzFiles.info(file);
		if (file.exists()) {
			Zyz.out("converting");
			JMHResult result = CONVERTER.converter(file);
			Zyz.out("serializing");
			ZuzSerializer.serializing(result, new File(file.getPath() + ".ser"));
		} else {
			System.err.println("not exist.");
		}
	}
	
	private static void sendResultJSONFile(
		File file) {
		if (file.exists()) {
		} else {
			System.err.println("not exist.");
		}
	}


	/**
	 * TODO what to do with that
	 */
//	private static Options opt() {
//		 return new OptionsBuilder()
//	            .include("*")
//	            .warmupTime(TimeValue.seconds(1))
//	            .warmupIterations(1)
//	            .measurementTime(TimeValue.seconds(1))
//	            .measurementIterations(1)
//	            .threads(1)
//	            .forks(1)
//	            .shouldFailOnError(true)
//	            .shouldDoGC(true)
	            // look at: https://stackoverflow.com/questions/20468900/should-i-run-jmh-benchmarks-with-server-option
//		        .jvmArgs("-server")
//	            .resultFormat(ResultFormatType.JSON)
//	            .output("JMH-output")
//	            .result("JMH-result")
//	            .build();
//	}
}
