package stringbenchmarking.benchmark.v01;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;

import stringbenchmarking.benchmark.StringBenchmark;
import stringbenchmarking.benchmark.v01.StringBenchmarkState.StringCancatenate;

public abstract class AbstractStringBenchmark extends StringBenchmark {

	private final StringBenchmarkState.StringCancatenate type;

	public AbstractStringBenchmark(
		StringCancatenate type) {
		super();
		this.type = type;
	}
	
	@Benchmark
	@BenchmarkMode({
		org.openjdk.jmh.annotations.Mode.AverageTime
	})
	public String example() {
		return "";
	}

//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x10() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_10);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x50() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_50);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x100() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_100);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x250() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_250);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x500() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_500);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x1000() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_1000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x2500() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_2500);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x5000() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_5000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x10000() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_10000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x20000() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_20000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_short_string_x50000() {
//		return type.concatenate(StringBenchmarkState.VALUES_S_50000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x10() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_10);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x50() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_50);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x100() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_100);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x250() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_250);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x500() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_500);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x1000() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_1000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x2500() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_2500);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x5000() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_5000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x10000() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_10000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x20000() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_20000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_medium_string_x50000() {
//		return type.concatenate(StringBenchmarkState.VALUES_M_50000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x10() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_10);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x50() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_50);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x100() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_100);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x250() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_250);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x500() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_500);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x1000() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_1000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x2500() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_2500);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x5000() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_5000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x10000() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_10000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x20000() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_20000);
//	}
//
//	@Benchmark
//	@BenchmarkMode({
//		org.openjdk.jmh.annotations.Mode.AverageTime
//	})
//	public String cancatenateWith_long_string_x50000() {
//		return type.concatenate(StringBenchmarkState.VALUES_L_50000);
//	}
}
