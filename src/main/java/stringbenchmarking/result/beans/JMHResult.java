package stringbenchmarking.result.beans;

public interface JMHResult {

	String getJMHVersion();

	// VM
	String getVMVersion();

	String getVMInvoker();

	String getVMOptions();

	String getWarmupInteractions();

	String getWarmupTime();

	String getMeasurementInteractions();

	String getMeasurementTime();

	String getTimeout();

	String getThreads();

	String getBenchmarkMode();

	String getBenchmarkingAction();

	Double getProgressPe();

	String getProgressETA();

	Integer getForkIndex();

	Integer getForkTotal();

	String getWarmupIterationMeasure();

	String getIterationMeasure();

	String getResultBenchmarkingAction();
}
