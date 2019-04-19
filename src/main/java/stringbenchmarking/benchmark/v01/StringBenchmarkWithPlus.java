package stringbenchmarking.benchmark.v01;

public class StringBenchmarkWithPlus
	extends
	AbstractStringBenchmark {

	public static StringBenchmarkState.StringCancatenate TYPE = StringBenchmarkState.PLUS;

	public StringBenchmarkWithPlus() {
		super(TYPE);
	}
}
