package stringbenchmarking.result.converter.line;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.commons.exception.JMHRuntimeException;
import stringbenchmarking.result.beans.Iteration;

public final class IterationLineConverter
	implements
	JMHResultLineConverter<Iteration> {

	@Override
	public Iteration converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		Iteration result = new Iteration();
		result.setIndex(Integer.valueOf(matcher.group(1)));
		String value = matcher.group(2);
		Double doubleValue = toDouble(value);
		result.setResult(doubleValue);
		return result;
	}

	private Double toDouble(
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

	private String regex() {
		return "Iteration[ ]+([0-9]+): ([0-9]+[,|\\.][0-9]+) ns/op";
	}
}
