package stringbenchmarking.result.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class Measurement
	implements
	Serializable {

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
		if (obj instanceof Measurement) {
			Measurement o = (Measurement) obj;
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