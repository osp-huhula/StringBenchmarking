package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResultAverage {

	private String score;
	private String percent;
	private String error;
	private String unit;

	public String getScore() {
		return score;
	}

	public void setScore(
		String score) {
		this.score = score;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(
		String percent) {
		this.percent = percent;
	}

	public String getError() {
		return error;
	}

	public void setError(
		String error) {
		this.error = error;
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
