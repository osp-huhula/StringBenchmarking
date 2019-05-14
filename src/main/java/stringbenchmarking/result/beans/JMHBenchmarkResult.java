package stringbenchmarking.result.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class JMHBenchmarkResult
	implements
	Serializable {

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
		if (obj instanceof JMHBenchmarkResult) {
			JMHBenchmarkResult o = (JMHBenchmarkResult) obj;
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
