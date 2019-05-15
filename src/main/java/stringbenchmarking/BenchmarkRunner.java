package stringbenchmarking;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import stringbenchmarking.commons.exception.JMHRuntimeException;
import stringbenchmarking.commons.exception.UnexpectedEOF;
import stringbenchmarking.commons.zuz.ZuzFiles;
import stringbenchmarking.commons.zuz.Zyz;
import stringbenchmarking.io.JMHResultSerializer;
import stringbenchmarking.result.beans.JMHResult;
import stringbenchmarking.result.converter.JMHOutputResultConverter;
import stringbenchmarking.result.converter.JMHOutputResultConverterDefault;

public class BenchmarkRunner {
	
	private static final JMHOutputResultConverter CONVERTER= new JMHOutputResultConverterDefault();

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
		File resultOutputFile = new File(parameters.get(parameters.indexOf("-o") 		+ 1));
		File resultJSONFile = new File(parameters.get(parameters.indexOf("-rff") 		+ 1));
		sendEMail(resultOutputFile, resultJSONFile);
	}

	private static void sendEMail(
		File resultOutput,
		File resultJSON) {
		ZuzFiles.info(resultOutput);
		ZuzFiles.info(resultJSON);
		
		List<File> files = new ArrayList<File>();
		files.add(resultOutput);
		files.add(resultJSON);
		
		
		if (resultOutput.exists()) {
			Zyz.out("converting");
			JMHResult result = converter(resultOutput);
			Zyz.out("serializing");
			byte[] serialized = JMHResultSerializer.serializing(result);
			
		} else {
			throw new JMHRuntimeException("File do not exist : " + resultOutput.getPath());
		}
		
		//sendEmail(resultJSON, resultJSON, serialized);
	}

	private static JMHResult converter(
		File resultOutput) {
		try {
			return CONVERTER.converter(resultOutput);
		} catch (UnexpectedEOF e) {
			throw new JMHRuntimeException(e);
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
