package stringbenchmarking.result.converter;

import org.apache.commons.lang3.StringUtils;

import stringbenchmarking.commons.exception.JMHRuntimeException;
import stringbenchmarking.enums.BenchmarkModeEnum;
import stringbenchmarking.result.beans.JMHResult;
import stringbenchmarking.result.beans.JMHResultImp;
import stringbenchmarking.result.beans.VirtualMachine;
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
		String[] values) {
		JMHResultImp result = new JMHResultImp();
		Index index = new Index();
		try {
			//HEADER
			result.setJMHVersion(new JMHVersionLineConverter().converter(values[index.index()]).toString());
			VirtualMachine virtualMachine = new VirtualMachine();
			virtualMachine.setVMVersion(new VMVersionLineConverter().converter(values[index.index()]));
			virtualMachine.setVMInvoker(new VMInvokerLineConverter().converter(values[index.index()]));
			virtualMachine.setVMOptions(new VMOptionsLineConverter().converter(values[index.index()]));
			result.setVirtualMachine(virtualMachine);
			result.setWarmup(new WarmupLineConverter().converter(values[index.index()]));
			result.setMeasurement(new MeasurementLineConverter().converter(values[index.index()]));
			result.setTimeout(new TimeoutLineConverter().converter(values[index.index()]).toString());
			result.setThreads(new ThreadLineConverter().converter(values[index.index()]).toString());
			BenchmarkModeEnum mode = new BenchmarkModeLineConverter().converter(values[index.index()]);
			result.setBenchmarkMode(mode.getValue());
			result.setBenchmarkingAction(new BenchmarkActionLineConverter().converter(values[index.index()]));
			if (StringUtils.isBlank(values[index.index()])) {
				System.out.println("- blank line");
			} else {
				throw new IllegalArgumentException("Blank line expected here.");
			}
			
			//PROCESS
			result.setRunProgressSummary(new RunProgressSummaryLineConverter().converter(values[index.index()]));
			result.setFork(new ForkLineConverter().converter(values[index.index()]));
			result.setWarmupMeasure(new WarmupIterationLineConverter().converter(values[index.index()]));
			result.setIterationMeasure(new IterationLineConverter().converter(values[index.index()]));
			
			//RESULT
			return result;
		} catch (Exception e) {
			String message = String.format("Could not convert line %s : [%s]", index.currentIndex() + 1, values[index.currentIndex()]);
			System.err.println(message);
			System.err.println(e.getMessage());
			throw new JMHRuntimeException(message, e);
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