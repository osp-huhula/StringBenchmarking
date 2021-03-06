package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class BenchmarkResultOne
	implements
	BenchmarkResult {

	private String score;
	private String unit;

	public String getScore() {
		return score;
	}

	public void setScore(
		String score) {
		this.score = score;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(
		String unit) {
		this.unit = unit;
	}
	
	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (getClass().isInstance(obj)) {
			BenchmarkResultOne o = (BenchmarkResultOne) obj;
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
