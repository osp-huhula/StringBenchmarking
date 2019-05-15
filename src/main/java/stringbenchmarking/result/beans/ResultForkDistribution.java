package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class ResultForkDistribution {

	private String peConfidenceInterval;
	private String min;
	private String max;

	public String getPeConfidenceInterval() {
		return peConfidenceInterval;
	}

	public void setPeConfidenceInterval(
		String peConfidenceInterval) {
		this.peConfidenceInterval = peConfidenceInterval;
	}

	public String getMin() {
		return min;
	}

	public void setMin(
		String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(
		String max) {
		this.max = max;
	}

	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof ResultForkDistribution) {
			ResultForkDistribution o = (ResultForkDistribution) obj;
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
