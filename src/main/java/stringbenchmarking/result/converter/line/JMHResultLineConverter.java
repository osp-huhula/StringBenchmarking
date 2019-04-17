package stringbenchmarking.result.converter.line;

public interface JMHResultLineConverter<T> {

	T converter(
		String content);
}
