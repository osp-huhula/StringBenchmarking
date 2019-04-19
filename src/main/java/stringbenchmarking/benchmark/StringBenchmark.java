package stringbenchmarking.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import stringbenchmarking.benchmark.v01.StringBenchmarkState;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(
	value = StringBenchmarkState.FORK)
@Warmup(
	iterations = StringBenchmarkState.WARMUP)
@Measurement(
	iterations = StringBenchmarkState.MEASUREMENT)
public class StringBenchmark {
}
