package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Measurement {

	private Integer iterations;
	private Integer seconds;

	public Integer getIterations() {
		return iterations;
	}

	public void setIterations(
		Integer nrIterations) {
		this.iterations = nrIterations;
	}

	public Integer getSeconds() {
		return seconds;
	}

	public void setSeconds(
		Integer seconds) {
		this.seconds = seconds;
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
		return ToStringBuilder.reflectionToString(this);
	}
}