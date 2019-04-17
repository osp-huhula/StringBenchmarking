package stringbenchmarking.result.beans;

public class WarmUp {

	private Integer iterations;
	private Integer seconds;

	public Integer getIterations() {
		return iterations;
	}

	public void setIterations(
		Integer nrIterations) {
		this.iterations = nrIterations;
	}

	public Integer getSeconds() {
		return seconds;
	}

	public void setSeconds(
		Integer seconds) {
		this.seconds = seconds;
	}
}
