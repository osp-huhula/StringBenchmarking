package stringbenchmarking.result.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class ResultFork {

	public void setAverage(
		ResultAverage converter) {
		// TODO Auto-generated method stub
		
	}

	public void setAverageStatistics(
		ResultStatistics converter) {
		// TODO Auto-generated method stub
		
	}
	
	public void setSingleResult(
		ResultForkSingle converter) {
		// TODO Auto-generated method stub
		
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
