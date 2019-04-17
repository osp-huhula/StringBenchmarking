package stringbenchmarking.result.converter.line;

import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;
import stringbenchmarking.result.beans.VirtualMachine;

public final class VMVersionLineConverter
	implements
	JMHResultLineConverter<VirtualMachine> {

	@Override
	public VirtualMachine converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		VirtualMachine result = new VirtualMachine();
		result.setJdkVersion(matcher.group(1));
		result.setVmVersion(matcher.group(2));
		return result;
	}

	private String regex() {
		return "# VM version: JDK ([0-9]+\\.[0-9]+\\.[0-9\\.\\-_a-zA-Z]+), VM ([0-9]+\\.[0-9\\.\\-_a-zA-Z]+)";
	}
}
