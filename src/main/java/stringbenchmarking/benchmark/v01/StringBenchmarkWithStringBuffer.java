package stringbenchmarking.benchmark.v01;

public class StringBenchmarkWithStringBuffer
	extends
	AbstractStringBenchmark {

	public static StringBenchmarkState.StringCancatenate TYPE = StringBenchmarkState.STRING_BUFFER;

	public StringBenchmarkWithStringBuffer() {
		super(TYPE);
	}
}
