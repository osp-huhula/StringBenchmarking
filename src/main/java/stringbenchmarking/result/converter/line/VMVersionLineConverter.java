package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.converter.line.beans.VMVersionLine;

public final class VMVersionLineConverter
	implements
	JMHResultLineConverter<VMVersionLine> {

	@Override
	public VMVersionLine converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		VMVersionLine result = new VMVersionLine();
		result.setJdkVersion(matcher.group(1));
		result.setVmVersion(matcher.group(2));
		return result;
	}

	private String regex() {
		return "# VM version: JDK ([0-9]+\\.[0-9_]+\\.[0-9\\.\\-_a-zA-Z]+), VM ([0-9]+\\.[0-9\\.\\-_a-zA-Z]+)";
	}
}
