package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import stringbenchmarking.commons.DoubleConverter;

public class IterationMeasure {

	private Integer index;
	private String result;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(
		Integer index) {
		this.index = index;
	}

	public String getResult() {
		return result;
	}

	public void setResult(
		String result) {
		this.result = result;
	}
	
	public Double getResultAsDouble() {
		return DoubleConverter.toDouble(result);
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
