package stringbenchmarking;

public class StringBenchmarkWithStringBuilder
	extends
	AbstractStringBenchmark {

	public static StringBenchmarkState.StringCancatenate TYPE = StringBenchmarkState.STRING_BUILDER;

	public StringBenchmarkWithStringBuilder() {
		super(TYPE);
	}
}
