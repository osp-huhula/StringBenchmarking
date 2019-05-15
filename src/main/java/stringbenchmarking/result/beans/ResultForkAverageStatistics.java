package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class ResultForkAverageStatistics {

	private String min;
	private String average;
	private String max;
	private String stdev;

	public String getMin() {
		return min;
	}

	public void setMin(
		String min) {
		this.min = min;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(
		String average) {
		this.average = average;
	}

	public String getMax() {
		return max;
	}

	public void setMax(
		String max) {
		this.max = max;
	}

	public String getStdev() {
		return stdev;
	}

	public void setStdev(
		String stdev) {
		this.stdev = stdev;
	}
	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof WarmupMeasure) {
			WarmupMeasure o = (WarmupMeasure) obj;
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
