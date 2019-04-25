package stringbenchmarking.commons.zuz;

import java.io.File;

import stringbenchmarking.commons.exception.JMHRuntimeException;

public class ZuzFiles {

	private static final int DEFAULT_XTIME_EXIST = 5;

	public static boolean waitExist(
		File file) {
		requiredFile(file);
		int xTimes = 0;
		while (!file.exists()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (xTimes > 5) {
				String message = "Tried " + DEFAULT_XTIME_EXIST + "x times to wait file to exist : "
					+ file.getPath();
				throw new JMHRuntimeException(message);
			}
			Zyz.out("tried time : " + xTimes);
			xTimes++;
		}
		return true;
	}

	public static boolean waitRead(
		File file) {
		requiredFile(file);
		int xTimes = 0;
		while (!file.canRead()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (xTimes > 5) {
				String message = "Tried " + DEFAULT_XTIME_EXIST + "x times to wait file to read : "
					+ file.getPath();
				throw new JMHRuntimeException(message);
			}
			Zyz.out("tried time : " + xTimes);
			xTimes++;
		}
		return true;
	}

	private static void requiredFile(
		File file) {
		if (file == null) {
			throw new JMHRuntimeException("File can't not be null.");
		}
	}

	public static void info(
		File file) {
		StringBuilder builder = new StringBuilder();
		builder.append(ZuzObjects.reflectionToString(file));
		builder.append("\npath          : " + file.getPath());
		builder.append("\nexists        : " + file.exists());
		builder.append("\nfree space    : " + file.getFreeSpace());
		builder.append("\ntotal space   : " + file.getTotalSpace());
		builder.append("\nusable space  : " + file.getUsableSpace());
		builder.append("\nmodified      : " + file.lastModified());
		builder.append("\nlength        : " + file.length());
		builder.append("\nfile          : " + file.isFile());
		builder.append("\ndirectory     : " + file.isDirectory());
		builder.append("\nabsolute      : " + file.isAbsolute());
		builder.append("\nhiden         : " + file.isHidden());
		builder.append("\nread          : " + file.canRead());
		builder.append("\nwrite         : " + file.canWrite());
		builder.append("\nexecute       : " + file.canExecute());
		Zyz.out(builder.toString());
	}
}
