package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class BenchmarkResultMany
	implements
	BenchmarkResult {

	private ResultForkAverageInfo information;
	private ResultForkAverageStatistics statistics;
	private ResultForkDistribution distribution;

	public ResultForkAverageInfo getInformation() {
		return information;
	}

	public void setInformation(
		ResultForkAverageInfo information) {
		this.information = information;
	}

	public ResultForkAverageStatistics getStatistics() {
		return statistics;
	}

	public void setStatistics(
		ResultForkAverageStatistics statistics) {
		this.statistics = statistics;
	}
	
	public ResultForkDistribution getDistribution() {
		return distribution;
	}

	public void setDistribution(
		ResultForkDistribution distribution) {
		this.distribution = distribution;
	}

	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (getClass().isInstance(obj)) {
			BenchmarkResultMany o = (BenchmarkResultMany) obj;
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
		return ZuzObjects.reflectionToString(this);
	}

}
