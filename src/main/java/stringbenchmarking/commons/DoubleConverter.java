package stringbenchmarking.commons;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

import stringbenchmarking.commons.exception.JMHRuntimeException;

public class DoubleConverter {

	public static Double toDouble(
		String value) {
		try {
			DecimalFormat format = new DecimalFormat();
			DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
			symbols.setDecimalSeparator(',');
			format.setDecimalFormatSymbols(symbols);
			return format.parse(value).doubleValue();
		} catch (ParseException e) {
			throw new JMHRuntimeException("Could not converter to Double : " + value, e);
		}
	}
}
