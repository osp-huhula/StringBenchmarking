package stringbenchmarking.result.beans;

public class JMHBenchmarkResult {

	private String name;
	private String type;
	private String count;
	private String score;
	private String error;
	private String units;

	public String getName() {
		return name;
	}

	public void setName(
		String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(
		String type) {
		this.type = type;
	}

	public String getCount() {
		return count;
	}

	public void setCount(
		String count) {
		this.count = count;
	}

	public String getScore() {
		return score;
	}

	public void setScore(
		String score) {
		this.score = score;
	}

	public String getError() {
		return error;
	}

	public void setError(
		String error) {
		this.error = error;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(
		String units) {
		this.units = units;
	}
}
