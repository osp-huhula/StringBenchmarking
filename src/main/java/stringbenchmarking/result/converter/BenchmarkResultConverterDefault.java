package stringbenchmarking.result.converter;

import org.apache.commons.lang3.StringUtils;

import stringbenchmarking.commons.exception.JMHRuntimeException;
import stringbenchmarking.enums.BenchmarkModeEnum;
import stringbenchmarking.result.beans.Fork;
import stringbenchmarking.result.beans.JMHResult;
import stringbenchmarking.result.beans.JMHResultImp;
import stringbenchmarking.result.beans.Measurement;
import stringbenchmarking.result.beans.VirtualMachine;
import stringbenchmarking.result.beans.Warmup;
import stringbenchmarking.result.converter.line.BenchmarkActionLineConverter;
import stringbenchmarking.result.converter.line.BenchmarkModeLineConverter;
import stringbenchmarking.result.converter.line.ForkLineConverter;
import stringbenchmarking.result.converter.line.IterationLineConverter;
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


public class BenchmarkResultConverterDefault
	implements
	ResultConverter {

	@Override
	public JMHResult converter(
		String content) {
		String[] result = content.split("\r\n|\r|\n");
		return converter(result);
	}

	private JMHResult converter(
		String[] contentLines) {
		JMHResultImp result = new JMHResultImp();
		StringValues values = new StringValues(contentLines);
		try {
			//HEADER
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
			blankLine(values);
			//PROCESS
			result.setRunProgressSummary(new RunProgressSummaryLineConverter().converter(values.next()));
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
			blankLine(values);
			int countFork = fork.getTotal() - 1;
			while (countFork > 0) {
				new RunProgressSummaryLineConverter().converter(values.next());
				new ForkLineConverter().converter(values.next());
				int countForkWarmup = Integer.valueOf(warmup.getIterations());
				while (countForkWarmup > 0) {
					new WarmupIterationLineConverter().converter(values.next());
					countForkWarmup--;
				}
				int countForkMeasurement = Integer.valueOf(measurement.getIterations());
				while (countForkMeasurement > 0) {
					new IterationLineConverter().converter(values.next());
					countForkMeasurement--;
				}
				countFork--;
				blankLine(values);
				blankLine(values);
				
				
			}
			
			boolean x = true;
			while(x) {
				System.err.println(values.next());
			}
			//RESULT
			return result;
		} catch (Exception e) {
			String message = String.format("Could not convert line %s : [%s]", values.currentIndex() + 1, contentLines[values.currentIndex()]);
			System.err.println(message);
			System.err.println(e.getMessage());
			throw new JMHRuntimeException(message, e);
		}
	}

	private void blankLine(
		StringValues values) {
		if (StringUtils.isBlank(values.next())) {
			System.out.println("- blank line");
		} else {
			throw new IllegalArgumentException("Blank line expected here.");
		}
	}

	class StringValues {

		private String[] values;
		private Index index;

		public StringValues(String[] values) {
			this(values, new Index());
		}

		public StringValues(
			String[] values, Index index) {
				this.values = values;
				this.index = index;
		}
		
		public String next() {
			return values[index.index()];
		}
		
		public int currentIndex() {
			return index.currentIndex();
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

		public int index() {
			index++;
			return index;
			
		}

	}
	
}