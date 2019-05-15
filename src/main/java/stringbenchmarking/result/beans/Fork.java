package stringbenchmarking.result.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import stringbenchmarking.commons.zuz.ZuzObjects;

public class Fork
	implements
	Serializable {

	private Integer index;
	private Integer total;
	private RunProgressSummary summary;
	private List<WarmupMeasure> warmupMeasures;
	private List<IterationMeasure> iterationMeasures;

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

	public RunProgressSummary getSummary() {
		return summary;
	}

	public void setSummary(
		RunProgressSummary summary) {
		this.summary = summary;
	}

	public List<WarmupMeasure> getWarmupMeasures() {
		return warmupMeasures;
	}

	public void setWarmupMeasures(
		List<WarmupMeasure> warmupMeasures) {
		this.warmupMeasures = warmupMeasures;
	}

	public List<IterationMeasure> getIterationMeasures() {
		return iterationMeasures;
	}

	public void setIterationMeasures(
		List<IterationMeasure> iterationMeasures) {
		this.iterationMeasures = iterationMeasures;
	}

	public void addWarmupMeasure(
		WarmupMeasure warmupMeasure) {
		if (getWarmupMeasures() == null) {
			setWarmupMeasures(new ArrayList<WarmupMeasure>());
		}
		getWarmupMeasures().add(warmupMeasure);
	}

	public boolean addIterationMeasure(
		IterationMeasure ierationMeasure) {
		if (getIterationMeasures() == null) {
			setIterationMeasures(new ArrayList<IterationMeasure>());
		}
		return getIterationMeasures().add(ierationMeasure);
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
