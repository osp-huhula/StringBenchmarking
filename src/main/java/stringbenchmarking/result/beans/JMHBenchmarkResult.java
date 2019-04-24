package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class JMHBenchmarkResult {

	private String name;
	private String type;
	private String count;
	private String score;
	private String error;
	private String units;

	public String getName() {
		return name;
	}

	public void setName(
		String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(
		String type) {
		this.type = type;
	}

	public String getCount() {
		return count;
	}

	public void setCount(
		String count) {
		this.count = count;
	}

	public String getScore() {
		return score;
	}

	public void setScore(
		String score) {
		this.score = score;
	}

	public String getError() {
		return error;
	}

	public void setError(
		String error) {
		this.error = error;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(
		String units) {
		this.units = units;
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
