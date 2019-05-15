package stringbenchmarking.result.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class JMHBenchmark
	implements
	Serializable {

	private String jmhVersion;
	private VirtualMachine virtualMachine;
	private Warmup warmup;
	private Measurement measurement;
	private String timeout;
	private String threads;
	private String benchmarkMode;
	private String benchmarkingAction;
	private List<BenchmarkResult> resultFork;
	private List<Fork> forks;

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

	public String getVMVersion() {
		return virtualMachine.getVMOptions();
	}

	public String getVMInvoker() {
		if (virtualMachine.getVMInvoker() == null) {
			return null;
		} else {
			return virtualMachine.getVMInvoker().getPath();
		}
	}

	public String getVMOptions() {
		return virtualMachine.getVMOptions();
	}

	public void setWarmup(
		Warmup warmup) {
		this.warmup = warmup;
	}

	public String getWarmupInteractions() {
		return toString(warmup.getIterations());
	}

	public String getWarmupTime() {
		return warmup.getUnit();
	}

	public void setMeasurement(
		Measurement measurement) {
		this.measurement = measurement;
	}

	public String getMeasurementInteractions() {
		return toString(measurement.getSeconds());
	}

	public String getMeasurementTime() {
		return toString(measurement.getSeconds());
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(
		String timeout) {
		this.timeout = timeout;
	}

	public String getThreads() {
		return threads;
	}

	public void setThreads(
		String threads) {
		this.threads = threads;
	}

	public String getBenchmarkMode() {
		return benchmarkMode;
	}

	public void setBenchmarkMode(
		String benchmarkMode) {
		this.benchmarkMode = benchmarkMode;
	}

	public String getBenchmarkingAction() {
		return benchmarkingAction;
	}

	public void setBenchmarkingAction(
		String benchmarkingAction) {
		this.benchmarkingAction = benchmarkingAction;
	}

	private String toString(
		Number number) {
		if (number == null) {
			return "null";
		} else {
			return number.toString();
		}
	}

	public boolean add(
		BenchmarkResult element) {
		if (getResultFork() == null) {
			setResultFork(new ArrayList<BenchmarkResult>());
		}
		return getResultFork().add(element);
	}

	public List<BenchmarkResult> getResultFork() {
		return resultFork;
	}

	public void setResultFork(
		List<BenchmarkResult> resultFork) {
		this.resultFork = resultFork;
	}

	public boolean add(
		Fork element) {
		if (getForks() == null) {
			setForks(new ArrayList<Fork>());
		}
		return getForks().add(element);
	}

	public List<Fork> getForks() {
		return forks;
	}

	public void setForks(
		List<Fork> forks) {
		this.forks = forks;
	}

	@Override
	public final boolean equals(
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
	public final int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public String toString() {
		return ZuzObjects.reflectionToString(this);
	}
}
