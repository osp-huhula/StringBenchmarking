package stringbenchmarking;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class DefaultEXHVerifier {

	public static void verify(
		Class<?> clazz) {
		verifier(clazz).verify();
	}

	public static void verifyReflection(
		Class<?> clazz) {
		verifier(clazz)
			.suppress(Warning.REFERENCE_EQUALITY)
			.suppress(Warning.NONFINAL_FIELDS)
			.verify();
	}

	private static EqualsVerifier<?> verifier(
		Class<?> clazz) {
		return EqualsVerifier.forClass(clazz);
	}
}
