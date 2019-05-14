package stringbenchmarking.result.converter;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import stringbenchmarking.commons.DateProvider;
import stringbenchmarking.commons.DateProviderDefault;
import stringbenchmarking.commons.exception.CustomEOFException;
import stringbenchmarking.commons.exception.JMHRuntimeException;
import stringbenchmarking.commons.exception.UnexpectedEOF;
import stringbenchmarking.commons.io.ZuzFileReader;
import stringbenchmarking.commons.zuz.Zyz;
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
import stringbenchmarking.result.converter.line.average.ResultSingleLineConverter;
import stringbenchmarking.result.converter.line.average.ResultStatisticsLineConverter;

public final class JMHOutputResultConverterDefault
	implements
	JMHOutputResultConverter {
	
	private final JMHVersionLineConverter jmhVersionLineConverter = new JMHVersionLineConverter();
	private final VMVersionLineConverter vmVersionLineConverter = new VMVersionLineConverter();
	private final VMInvokerLineConverter vmInvokerLineConverter = new VMInvokerLineConverter();
	private final VMOptionsLineConverter vmOptionsLineConverter = new VMOptionsLineConverter();
	private final MeasurementLineConverter measurementLineConverter = new MeasurementLineConverter();
	private final TimeoutLineConverter timeoutLineConverter = new TimeoutLineConverter();
	private final ThreadLineConverter threadLineConverter = new ThreadLineConverter();
	private final BenchmarkModeLineConverter benchmarkModeLineConverter = new BenchmarkModeLineConverter();
	private final BenchmarkActionLineConverter benchmarkActionLineConverter = new BenchmarkActionLineConverter();
	private final RunProgressSummaryLineConverter runProgressSummaryLineConverter = new RunProgressSummaryLineConverter();
	private final WarmupIterationLineConverter warmupIterationLineConverter = new WarmupIterationLineConverter();
	private final IterationLineConverter iterationLineConverter = new IterationLineConverter();
	private final ResultAverageLineConverter resultAverageLineConverter = new ResultAverageLineConverter();
	private final ResultSingleLineConverter resultSingleLineConverter = new ResultSingleLineConverter();
	private final ResultStatisticsLineConverter resultStatisticsLineConverter = new ResultStatisticsLineConverter();
	private final DateProvider dateProvider;
	
	public JMHOutputResultConverterDefault() {
		this(new DateProviderDefault());
	}
	
	public JMHOutputResultConverterDefault(
		DateProvider dateProvider) {
		super();
		this.dateProvider = dateProvider;
	}

	@Override
	public JMHResult converter(
		File file)
		throws UnexpectedEOF {
		String content = new ZuzFileReader().readFile(file);
		if (StringUtils.isBlank(content)) {
			throw new JMHRuntimeException("File : [" + file.getPath() + "] has no content.");
		} else {
			return converter(content);
		}
	}

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
		result.setProcessStart(dateProvider);
		try {
			while (values.currentIndex() == -1 || !values.preview().startsWith("# Run complete") ) {
				values.nextNonBlankLine();
				converterBenchmark(result, values);
			}
			result.setTimeTotal(new JMHResultTotalTimeLineConverter().converter(values.next()));
			values.nextNonBlankLine();
			System.err.println(values.next());
			values.nextNonBlankLine();
			System.out.println("----");
			while (values.notEOF() && !StringUtils.isBlank(values.preview())) {
				Zyz.err(values.preview());
				result.add(new BenchmarkResultLineConverter().converter(values.next()));
			}
			result.setProcessEnd(dateProvider);
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
		result.setJMHVersion(jmhVersionLineConverter.converter(values.next()).toString());
		VirtualMachine virtualMachine = new VirtualMachine();
		virtualMachine.setVMVersion(vmVersionLineConverter.converter(values.next()));
		virtualMachine.setVMInvoker(vmInvokerLineConverter.converter(values.next()));
		virtualMachine.setVMOptions(vmOptionsLineConverter.converter(values.next()));
		result.setVirtualMachine(virtualMachine);
		String lineWarmup = values.next();
		Measurement measurement = measurementLineConverter.converter(values.next());
		result.setMeasurement(measurement);
		result.setTimeout(timeoutLineConverter.converter(values.next()).toString());
		result.setThreads(threadLineConverter.converter(values.next()).toString());
		BenchmarkModeEnum mode = benchmarkModeLineConverter.converter(values.next());
		result.setBenchmarkMode(mode.getValue());
		Warmup warmup = new WarmupLineConverter(mode).converter(lineWarmup);
		result.setWarmup(warmup);
		result.setBenchmarkingAction(benchmarkActionLineConverter.converter(values.next()));
		values.blankLine();
		// PROCESS
		result
			.setRunProgressSummary(runProgressSummaryLineConverter.converter(values.next()));
		Fork fork = new ForkLineConverter().converter(values.next());
		result.setFork(fork);
		int countWarmup = Integer.valueOf(warmup.getIterations());
		while (countWarmup > 0) {
			result.addWarmupMeasure(warmupIterationLineConverter.converter(values.next()));
			countWarmup--;
		}
		int countMeasurement = Integer.valueOf(measurement.getIterations());
		while (countMeasurement > 0) {
			result.addIterationMeasure(iterationLineConverter.converter(values.next()));
			countMeasurement--;
		}
		values.nextNonBlankLine();
		int countFork = fork.getTotal() - 1;
		while (countFork > 0) {
			runProgressSummaryLineConverter.converter(values.next());
			new ForkLineConverter().converter(values.next());
			int countForkWarmup = Integer.valueOf(warmup.getIterations());
			while (countForkWarmup > 0) {
				result
					.addWarmupMeasure(warmupIterationLineConverter.converter(values.next()));
				countForkWarmup--;
			}
			int countForkMeasurement = Integer.valueOf(measurement.getIterations());
			while (countForkMeasurement > 0) {
				result.addIterationMeasure(iterationLineConverter.converter(values.next()));
				countForkMeasurement--;
			}
			countFork--;
			values.nextNonBlankLine();
		}
		System.err.println(values.next());
		ResultFork resultAverage = new ResultFork();
		if (fork.getTotal() == 1) {
			resultAverage.setSingleResult(resultSingleLineConverter.converter(values.next()));
		} else {
			resultAverage.setAverage(resultAverageLineConverter.converter(values.next()));
			resultAverage.setAverageStatistics(resultStatisticsLineConverter.converter(values.next()));
			System.err.println(values.next());// TODO
			// confidence interval
		}
		values.nextNonBlankLine();
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
		
		public void nextNonBlankLine() throws CustomEOFException {
			while (StringUtils.isBlank(preview())) {
				blankLine();
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
