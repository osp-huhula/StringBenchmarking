package stringbenchmarking.result.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class Fork
	implements
	Serializable {

	private Integer index;
	private Integer total;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(
		Integer index) {
		this.index = index;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(
		Integer total) {
		this.total = total;
	}
	
	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Fork) {
			Fork o = (Fork) obj;
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
