package stringbenchmarking.benchmark.v01;

import java.util.ArrayList;
import java.util.Collection;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class StringBenchmarkState {
	interface StringCancatenate {

		String concatenate(
			String[] values);
	}

	static class StringCancatenateWithPlus
		implements
		StringCancatenate {

		@Override
		public String concatenate(
			String[] values) {
			String result = "";
			for (String s : values) {
				s = result + s;
			}
			return result;
		}
	}

	static class StringCancatenateWithConcat
		implements
		StringCancatenate {

		@Override
		public String concatenate(
			String[] values) {
			String result = "";
			for (String s : values) {
				s = result.concat(s);
			}
			return result;
		}
	}

	static class StringCancatenateWithStringBuilder
		implements
		StringCancatenate {

		@Override
		public String concatenate(
			String[] values) {
			StringBuilder builder = new StringBuilder();
			for (String s : values) {
				builder.append(s);
			}
			return builder.toString();
		}
	}

	static class StringCancatenateWithStringBuffer
		implements
		StringCancatenate {

		@Override
		public String concatenate(
			String[] values) {
			StringBuffer builder = new StringBuffer();
			for (String s : values) {
				builder.append(s);
			}
			return builder.toString();
		}
	}

	public static final org.openjdk.jmh.annotations.Mode[] MODES = new Mode[] {
		org.openjdk.jmh.annotations.Mode.AverageTime,
		org.openjdk.jmh.annotations.Mode.SingleShotTime
	};
	public static final int FORK = 20;
	public static final int WARMUP = 20;
	public static final int MEASUREMENT = 20;

	public static StringCancatenate PLUS = new StringCancatenateWithPlus();
	public static StringCancatenate CONCAT = new StringCancatenateWithConcat();
	public static StringCancatenate STRING_BUILDER = new StringCancatenateWithStringBuilder();
	public static StringCancatenate STRING_BUFFER = new StringCancatenateWithStringBuffer();
	
	public static int LENGHT_SHORT = 10;
	public static int LENGHT_MEDIUM = 100;
	public static int LENGHT_LONG = 1000;
	
	public static int TIMES_10 		= 10;
	public static int TIMES_50 		= 50;
	public static int TIMES_100 	= 100;
	public static int TIMES_250 	= 250;
	public static int TIMES_500 	= 500;
	public static int TIMES_1000 	= 1000;
	public static int TIMES_2500 	= 2500;
	public static int TIMES_5000 	= 5000;
	public static int TIMES_10000 	= 10000;
	public static int TIMES_20000 	= 20000;
	public static int TIMES_50000 	= 50000;
	
	public static String[] VALUES_S_10 = array(LENGHT_SHORT, TIMES_10);
	public static String[] VALUES_S_50 = array(LENGHT_SHORT, TIMES_50);
	public static String[] VALUES_S_100 = array(LENGHT_SHORT, TIMES_100);
	public static String[] VALUES_S_250 = array(LENGHT_SHORT, TIMES_250);
	public static String[] VALUES_S_500 = array(LENGHT_SHORT, TIMES_500);
	public static String[] VALUES_S_1000 = array(LENGHT_SHORT, TIMES_1000);
	public static String[] VALUES_S_2500 = array(LENGHT_SHORT, TIMES_2500);
	public static String[] VALUES_S_5000 = array(LENGHT_SHORT, TIMES_5000);
	public static String[] VALUES_S_10000 = array(LENGHT_SHORT, TIMES_10000);
	public static String[] VALUES_S_20000 = array(LENGHT_SHORT, TIMES_20000);
	public static String[] VALUES_S_50000 = array(LENGHT_SHORT, TIMES_50000);
	
	public static String[] VALUES_M_10 = array(LENGHT_MEDIUM, TIMES_10);
	public static String[] VALUES_M_50 = array(LENGHT_MEDIUM, TIMES_50);
	public static String[] VALUES_M_100 = array(LENGHT_MEDIUM, TIMES_100);
	public static String[] VALUES_M_250 = array(LENGHT_MEDIUM, TIMES_250);
	public static String[] VALUES_M_500 = array(LENGHT_MEDIUM, TIMES_500);
	public static String[] VALUES_M_1000 = array(LENGHT_MEDIUM, TIMES_1000);
	public static String[] VALUES_M_2500 = array(LENGHT_MEDIUM, TIMES_2500);
	public static String[] VALUES_M_5000 = array(LENGHT_MEDIUM, TIMES_5000);
	public static String[] VALUES_M_10000 = array(LENGHT_MEDIUM, TIMES_10000);
	public static String[] VALUES_M_20000 = array(LENGHT_MEDIUM, TIMES_20000);
	public static String[] VALUES_M_50000 = array(LENGHT_MEDIUM, TIMES_50000);
	
	public static String[] VALUES_L_10 = array(LENGHT_LONG, TIMES_10);
	public static String[] VALUES_L_50 = array(LENGHT_LONG, TIMES_50);
	public static String[] VALUES_L_100 = array(LENGHT_LONG, TIMES_100);
	public static String[] VALUES_L_250 = array(LENGHT_LONG, TIMES_250);
	public static String[] VALUES_L_500 = array(LENGHT_LONG, TIMES_500);
	public static String[] VALUES_L_1000 = array(LENGHT_LONG, TIMES_1000);
	public static String[] VALUES_L_2500 = array(LENGHT_LONG, TIMES_2500);
	public static String[] VALUES_L_5000 = array(LENGHT_LONG, TIMES_5000);
	public static String[] VALUES_L_10000 = array(LENGHT_LONG, TIMES_10000);
	public static String[] VALUES_L_20000 = array(LENGHT_LONG, TIMES_20000);
	public static String[] VALUES_L_50000 = array(LENGHT_LONG, TIMES_50000);
	
	public static char DEFAULT_CHARACTER = 'X';

	private static String[] array(
		int xLenght,
		int xTimes) {
		
		int xValueLenght = 0;
		String value = "";
		while(xValueLenght < xLenght) {
			value = value + DEFAULT_CHARACTER;
			xValueLenght++;
		}
		Collection<String> result = new ArrayList<String>();
		int xCollectionSize = 0;
		while(xCollectionSize < xTimes) {
			result.add(value);
			xCollectionSize++;
		}
		return result.toArray(new String[]{});
	}
}

