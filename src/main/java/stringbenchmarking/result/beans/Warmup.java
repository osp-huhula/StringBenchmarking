package stringbenchmarking.result.beans;

public class Warmup {

	private Integer iterations;
	private String unit;

	public Integer getIterations() {
		return iterations;
	}

	public void setIterations(
		Integer nrIterations) {
		this.iterations = nrIterations;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(
		String unit) {
		this.unit = unit;
	}
}
