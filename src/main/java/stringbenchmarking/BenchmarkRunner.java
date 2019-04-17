package stringbenchmarking;

public class BenchmarkRunner {

	public static void main(
		String[] args)
		throws Exception {
//		org.openjdk.jmh.runner.options.Options opt = new org.openjdk.jmh.runner.options.OptionsBuilder()
//         .include(JMHSample_01_HelloWorld.class.getSimpleName())
//         .warmupIterations(2)
//         .measurementIterations(5)
//         .forks(1)
//         .shouldDoGC(true) 
//         .build();
		org.openjdk.jmh.Main.main(args);
	}
}
