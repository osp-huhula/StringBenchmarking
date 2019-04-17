package stringbenchmarking.result.converter.line;

import java.io.File;
import java.util.regex.Matcher;

import stringbenchmarking.commons.CommonsMatcher;

public final class VMInvokerLineConverter
	implements
	JMHResultLineConverter<File> {

	@Override
	public File converter(
		String content) {
		String regex = regex();
		Matcher matcher = CommonsMatcher.matcher(regex, content);
		return new File(matcher.group(1));
	}

	private String regex() {
		return "# VM invoker: ([.]*)";
	}
}
