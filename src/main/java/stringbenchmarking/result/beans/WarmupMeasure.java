package stringbenchmarking.result.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.DoubleConverter;
import stringbenchmarking.commons.zuz.ZuzObjects;

public class WarmupMeasure
	implements
	Serializable {

	private Integer index;
	private String score;
	private String pe;
	private String scoreError;
	private String unit;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(
		Integer index) {
		this.index = index;
	}

	public String getScore() {
		return score;
	}
	
	public Double getScoreAsDouble() {
		return DoubleConverter.toDouble(score);
	}

	public void setScore(
		String score) {
		this.score = score;
	}

	public String getScoreError() {
		return scoreError;
	}

	public void setScoreError(
		String scoreError) {
		this.scoreError = scoreError;
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
		return ZuzObjects.reflectionToString(this);
	}
}
