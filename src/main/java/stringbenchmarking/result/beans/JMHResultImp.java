package stringbenchmarking.result.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.DateProvider;
import stringbenchmarking.commons.zuz.ZuzObjects;

public class JMHResultImp
	implements
	JMHResult {

	private String dtStart;
	private String dtEnd;
	private String timeTotal;
	private List<JMHBenchmark> benchmarks;
	private List<JMHBenchmarkResult> benchmarkResults;

	public String getTimeTotal() {
		return timeTotal;
	}

	public void setTimeTotal(
		String timeTotal) {
		this.timeTotal = timeTotal;
	}

	public String getDtStart() {
		return dtStart;
	}

	public void setDtStart(
		String dtStart) {
		this.dtStart = dtStart;
	}

	public String getDtEnd() {
		return dtEnd;
	}

	public void setDtEnd(
		String dtEnd) {
		this.dtEnd = dtEnd;
	}

	public void setProcessStart(
		DateProvider provider) {
		setDtStart(provider.nowAsString());
	}

	public void setProcessEnd(
		DateProvider provider) {
		setDtEnd(provider.nowAsString());
	}

	public boolean add(
		JMHBenchmark element) {
		if (getBenchmarks() == null) {
			setBenchmarks(new ArrayList<JMHBenchmark>());
		}
		return getBenchmarks().add(element);
	}

	public List<JMHBenchmark> getBenchmarks() {
		return benchmarks;
	}

	public void setBenchmarks(
		List<JMHBenchmark> benchmarks) {
		this.benchmarks = benchmarks;
	}

	public List<JMHBenchmarkResult> getBenchmarkResults() {
		return benchmarkResults;
	}

	public void setBenchmarkResults(
		List<JMHBenchmarkResult> benchmarkResults) {
		this.benchmarkResults = benchmarkResults;
	}

	public boolean add(
		JMHBenchmarkResult element) {
		if (getBenchmarkResults() == null) {
			setBenchmarkResults(new ArrayList<JMHBenchmarkResult>());
		}
		return getBenchmarkResults().add(element);
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
