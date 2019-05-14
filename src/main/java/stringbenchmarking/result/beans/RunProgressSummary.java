package stringbenchmarking.result.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class RunProgressSummary
	implements
	Serializable {

	private Double peComplete;
	private String eta;

	public Double getPeComplete() {
		return peComplete;
	}

	public void setPeComplete(
		Double peComplete) {
		this.peComplete = peComplete;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(
		String eta) {
		this.eta = eta;
	}
	
	@Override
	public boolean equals(
		Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof RunProgressSummary) {
			RunProgressSummary o = (RunProgressSummary) obj;
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
