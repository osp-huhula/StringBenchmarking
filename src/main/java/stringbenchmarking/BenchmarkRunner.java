package stringbenchmarking;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class BenchmarkRunner {

	public static void main(
		String[] args)
		throws Exception {
//		Options opt = opt();
//		new org.openjdk.jmh.runner.Runner(opt);
		System.out.println("start");
		org.openjdk.jmh.Main.main(args);
		System.out.println("end");
		List<String> parameters = Arrays.asList(args);
		sendFile(new File(parameters.get(parameters.indexOf("-o") 			+ 1)));
		sendFile(new File(parameters.get(parameters.indexOf("-rff") 		+ 1)));
		
	}

	private static void sendFile(
		File file) {
		if(file.exists()) {
			
		}else {
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
