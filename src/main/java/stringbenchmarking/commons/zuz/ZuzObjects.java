package stringbenchmarking.commons.zuz;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ZuzObjects {

	private static ToStringStyle DEFAULT_STYLE = ToStringStyle.DEFAULT_STYLE;

	@Deprecated
	/**
	 * Use 4T -> Will be removed in a future TODO
	 * @deprecated
	 * @param style
	 */
	public static void changeDefaultStyle(
		ToStringStyle style) {
		DEFAULT_STYLE = style;
	}

	public static String reflectionToString(
		Object object) {
		return ToStringBuilder.reflectionToString(object, DEFAULT_STYLE);
	}

	public static String reflectionToString(
		Object object,
		ToStringStyle style) {
		return ToStringBuilder.reflectionToString(object, style);
	}
}
