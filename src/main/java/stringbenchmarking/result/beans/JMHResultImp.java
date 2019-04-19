package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class JMHResultImp
	implements
	JMHResult {

	private String jmhVersion;
	private VirtualMachine virtualMachine;
	private Warmup warmup;
	private Measurement measurement;
	private String timeout;
	private String threads;
	private String benchmarkMode;
	private String benchmarkingAction;
	private RunProgressSummary runProgressSummary;
	private Fork fork;
	private WarmupMeasure warmupMeasure;
	private IterationMeasure iterationMeasure;
	private String resultBenchmarkingAction;

	@Override
	public String getJMHVersion() {
		return jmhVersion;
	}

	public void setJMHVersion(
		String jmhVersion) {
		this.jmhVersion = jmhVersion;
	}

	public VirtualMachine getVirtualMachine() {
		return virtualMachine;
	}

	public void setVirtualMachine(
		VirtualMachine virtualMachine) {
		this.virtualMachine = virtualMachine;
	}

	@Override
	public String getVMVersion() {
		return virtualMachine.getVMOptions();
	}

	@Override
	public String getVMInvoker() {
		if (virtualMachine.getVMInvoker() == null) {
			return null;
		} else {
			return virtualMachine.getVMInvoker().getPath();
		}
	}

	@Override
	public String getVMOptions() {
		return virtualMachine.getVMOptions();
	}

	public void setWarmup(
		Warmup warmup) {
		this.warmup = warmup;
	}

	@Override
	public String getWarmupInteractions() {
		return toString(warmup.getIterations());
	}

	@Override
	public String getWarmupTime() {
		return toString(warmup.getSeconds());
	}

	public void setMeasurement(
		Measurement measurement) {
		this.measurement = measurement;
	}

	@Override
	public String getMeasurementInteractions() {
		return toString(measurement.getSeconds());
	}

	@Override
	public String getMeasurementTime() {
		return toString(measurement.getSeconds());
	}

	@Override
	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(
		String timeout) {
		this.timeout = timeout;
	}

	@Override
	public String getThreads() {
		return threads;
	}

	public void setThreads(
		String threads) {
		this.threads = threads;
	}

	@Override
	public String getBenchmarkMode() {
		return benchmarkMode;
	}

	public void setBenchmarkMode(
		String benchmarkMode) {
		this.benchmarkMode = benchmarkMode;
	}

	@Override
	public String getBenchmarkingAction() {
		return benchmarkingAction;
	}

	public void setBenchmarkingAction(
		String benchmarkingAction) {
		this.benchmarkingAction = benchmarkingAction;
	}

	public void setRunProgressSummary(
		RunProgressSummary runProgressSummary) {
		this.runProgressSummary = runProgressSummary;
	}

	@Override
	public Double getProgressPe() {
		return runProgressSummary.getPeComplete();
	}

	@Override
	public String getProgressETA() {
		return runProgressSummary.getEta();
	}

	public void setFork(
		Fork fork) {
		this.fork = fork;
	}

	@Override
	public Integer getForkIndex() {
		return fork.getIndex();
	}

	@Override
	public Integer getForkTotal() {
		return fork.getTotal();
	}

	public void setWarmupMeasure(
		WarmupMeasure warmupMeasure) {
		this.warmupMeasure = warmupMeasure;
	}

	@Override
	public String getWarmupIterationMeasure() {
		return warmupMeasure.getResult();
	}

	public void setIterationMeasure(
		IterationMeasure iterationMeasure) {
		this.iterationMeasure = iterationMeasure;
	}

	@Override
	public String getIterationMeasure() {
		return iterationMeasure.getResult();
	}

	@Override
	public String getResultBenchmarkingAction() {
		return resultBenchmarkingAction;
	}

	public void setResultBenchmarkingAction(
		String resultBenchmarkingAction) {
		this.resultBenchmarkingAction = resultBenchmarkingAction;
	}

	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof JMHResultImp) {
			JMHResultImp o = (JMHResultImp) obj;
			return EqualsBuilder.reflectionEquals(this, o, true);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	private String toString(
		Number number) {
		if (number == null) {
			return "null";
		} else {
			return number.toString();
		}
	}
}
