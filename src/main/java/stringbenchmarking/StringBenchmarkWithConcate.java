package stringbenchmarking;

public class StringBenchmarkWithConcate
	extends
	AbstractStringBenchmark {

	public static StringBenchmarkState.StringCancatenate TYPE = StringBenchmarkState.CONCAT;

	public StringBenchmarkWithConcate() {
		super(StringBenchmarkState.CONCAT);
	}
}
