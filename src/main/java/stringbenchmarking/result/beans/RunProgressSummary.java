package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RunProgressSummary {

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
