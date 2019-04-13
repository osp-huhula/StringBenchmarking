package stringbenchmarking;

public class StringBenchmarkWithPlus
	extends
	AbstractStringBenchmark {

	public static StringBenchmarkState.StringCancatenate TYPE = StringBenchmarkState.PLUS;

	public StringBenchmarkWithPlus() {
		super(TYPE);
	}
}
