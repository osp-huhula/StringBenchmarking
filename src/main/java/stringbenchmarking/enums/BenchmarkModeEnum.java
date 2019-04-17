package stringbenchmarking.enums;

import stringbenchmarking.commons.exception.JMHRuntimeException;

public enum BenchmarkModeEnum {
		THROUGHPUT("Throughput"),
		;

	private final String value;

	private BenchmarkModeEnum(
		String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static BenchmarkModeEnum fromValue(
		String reference) {
		for (BenchmarkModeEnum enumm : values()) {
			if (enumm.getValue().equals(reference)) {
				return enumm;
			}
		}
		throw new JMHRuntimeException("no enum found for :" + reference);
	}
}
