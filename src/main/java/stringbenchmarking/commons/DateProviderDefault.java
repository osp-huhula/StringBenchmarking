package stringbenchmarking.commons;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProviderDefault
	implements
	DateProvider {

	public String nowAsString() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd.HHmmssSSS");
		return formatter.format(ts);
	}
}
