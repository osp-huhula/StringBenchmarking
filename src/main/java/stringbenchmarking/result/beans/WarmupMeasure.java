package stringbenchmarking.result.beans;

import stringbenchmarking.commons.DoubleConverter;

public class WarmupMeasure {

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
}
