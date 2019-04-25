package stringbenchmarking.result.converter;

import org.apache.commons.lang3.StringUtils;

import stringbenchmarking.commons.exception.CustomEOFException;
import stringbenchmarking.commons.exception.JMHRuntimeException;
import stringbenchmarking.commons.exception.UnexpectedEOF;
import stringbenchmarking.enums.BenchmarkModeEnum;
import stringbenchmarking.result.beans.Fork;
import stringbenchmarking.result.beans.JMHResult;
import stringbenchmarking.result.beans.JMHResultImp;
import stringbenchmarking.result.beans.Measurement;
import stringbenchmarking.result.beans.ResultFork;
import stringbenchmarking.result.beans.VirtualMachine;
import stringbenchmarking.result.beans.Warmup;
import stringbenchmarking.result.converter.line.BenchmarkActionLineConverter;
import stringbenchmarking.result.converter.line.BenchmarkModeLineConverter;
import stringbenchmarking.result.converter.line.BenchmarkResultLineConverter;
import stringbenchmarking.result.converter.line.ForkLineConverter;
import stringbenchmarking.result.converter.line.IterationLineConverter;
import stringbenchmarking.result.converter.line.JMHResultTotalTimeLineConverter;
import stringbenchmarking.result.converter.line.JMHVersionLineConverter;
import stringbenchmarking.result.converter.line.MeasurementLineConverter;
import stringbenchmarking.result.converter.line.RunProgressSummaryLineConverter;
import stringbenchmarking.result.converter.line.ThreadLineConverter;
import stringbenchmarking.result.converter.line.TimeoutLineConverter;
import stringbenchmarking.result.converter.line.VMInvokerLineConverter;
import stringbenchmarking.result.converter.line.VMOptionsLineConverter;
import stringbenchmarking.result.converter.line.VMVersionLineConverter;
import stringbenchmarking.result.converter.line.WarmupIterationLineConverter;
import stringbenchmarking.result.converter.line.WarmupLineConverter;
import stringbenchmarking.result.converter.line.average.ResultAverageLineConverter;
import stringbenchmarking.result.converter.line.average.ResultStatisticsLineConverter;

public final class JMHOutputResultConverterDefault
	implements
	JMHOutputResultConverter {

	@Override
	public JMHResult converter(
		String content)
		throws UnexpectedEOF {
		String[] result = content.split("\r\n|\r|\n");
		return converter(result);
	}

	private JMHResult converter(
		String[] contentLines)
		throws UnexpectedEOF {
		return converter(new StringValues(contentLines));
	}

	private JMHResult converter(
		StringValues values)
		throws UnexpectedEOF {
		JMHResultImp result = new JMHResultImp();
		try {
			while (values.currentIndex() == -1 || !values.preview().startsWith("# Run complete")) {
				converterBenchmark(result, values);
			}
			result.setTimeTotal(new JMHResultTotalTimeLineConverter().converter(values.next()));
			values.blankLine();
			System.err.println(values.next());
			System.out.println("----");
			while (values.notEOF()) {
				result.add(new BenchmarkResultLineConverter().converter(values.next()));
			}
			return result;
		} catch (CustomEOFException e) {
			throw new UnexpectedEOF(result, e);
		} catch (Exception e) {
			String message = String.format("Could not convert line %s : [%s]",
				values.currentIndex() + 1, values.current());
			System.err.println(message);
			System.err.println(e.getMessage());
			throw new JMHRuntimeException(message, e);
		}
	}

	private void converterBenchmark(
		JMHResultImp result,
		StringValues values)
		throws CustomEOFException {
		// HEADER
		result.setJMHVersion(new JMHVersionLineConverter().converter(values.next()).toString());
		VirtualMachine virtualMachine = new VirtualMachine();
		virtualMachine.setVMVersion(new VMVersionLineConverter().converter(values.next()));
		virtualMachine.setVMInvoker(new VMInvokerLineConverter().converter(values.next()));
		virtualMachine.setVMOptions(new VMOptionsLineConverter().converter(values.next()));
		result.setVirtualMachine(virtualMachine);
		String lineWarmup = values.next();
		Measurement measurement = new MeasurementLineConverter().converter(values.next());
		result.setMeasurement(measurement);
		result.setTimeout(new TimeoutLineConverter().converter(values.next()).toString());
		result.setThreads(new ThreadLineConverter().converter(values.next()).toString());
		BenchmarkModeEnum mode = new BenchmarkModeLineConverter().converter(values.next());
		result.setBenchmarkMode(mode.getValue());
		Warmup warmup = new WarmupLineConverter(mode).converter(lineWarmup);
		result.setWarmup(warmup);
		result.setBenchmarkingAction(new BenchmarkActionLineConverter().converter(values.next()));
		values.blankLine();
		// PROCESS
		result
			.setRunProgressSummary(new RunProgressSummaryLineConverter().converter(values.next()));
		Fork fork = new ForkLineConverter().converter(values.next());
		result.setFork(fork);
		int countWarmup = Integer.valueOf(warmup.getIterations());
		while (countWarmup > 0) {
			result.addWarmupMeasure(new WarmupIterationLineConverter().converter(values.next()));
			countWarmup--;
		}
		int countMeasurement = Integer.valueOf(measurement.getIterations());
		while (countMeasurement > 0) {
			result.addIterationMeasure(new IterationLineConverter().converter(values.next()));
			countMeasurement--;
		}
		values.blankLine();
		int countFork = fork.getTotal() - 1;
		while (countFork > 0) {
			new RunProgressSummaryLineConverter().converter(values.next());
			new ForkLineConverter().converter(values.next());
			int countForkWarmup = Integer.valueOf(warmup.getIterations());
			while (countForkWarmup > 0) {
				result
					.addWarmupMeasure(new WarmupIterationLineConverter().converter(values.next()));
				countForkWarmup--;
			}
			int countForkMeasurement = Integer.valueOf(measurement.getIterations());
			while (countForkMeasurement > 0) {
				result.addIterationMeasure(new IterationLineConverter().converter(values.next()));
				countForkMeasurement--;
			}
			countFork--;
			values.blankLine();
			values.blankLine();
			System.err.println(values.next());
			ResultFork resultAverage = new ResultFork();
			resultAverage.setAverage(new ResultAverageLineConverter().converter(values.next()));
			resultAverage
				.setAverageStatistics(new ResultStatisticsLineConverter().converter(values.next()));
			System.err.println(values.next());// TODO
			// confidence interval
			values.blankLine();
			values.blankLine();
		}
	}

	class StringValues {

		private String[] values;
		private Index index;

		public StringValues(
			String[] values) {
			this(values, new Index());
		}

		public boolean notEOF() {
			return this.currentIndex() < values.length - 1;
		}

		public StringValues(
			String[] values,
			Index index) {
			this.values = values;
			this.index = index;
		}

		public String next()
			throws CustomEOFException {
			int current = index.next();
			if (current == values.length) {
				throw new CustomEOFException();
			} else {
				return values[current];
			}
		}

		public int currentIndex() {
			return index.currentIndex();
		}

		public String current() {
			return values[index.currentIndex()];
		}

		public String preview() {
			return values[index.currentIndex() + 1];
		}

		public void blankLine()
			throws CustomEOFException {
			if (StringUtils.isBlank(next())) {
				System.out.println("- blank line");
			} else {
				throw new IllegalArgumentException("Blank line expected here.");
			}
		}
	}

	class Index {

		private int index;

		public Index() {
			this(-1);
		}

		public Index(
			int index) {
			super();
			this.index = index;
		}

		public int currentIndex() {
			return index;
		}

		public int next() {
			index++;
			return index;
		}
	}
}
