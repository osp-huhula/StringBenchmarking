package stringbenchmarking.commons.zuz;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import stringbenchmarking.commons.AutoCloser;
import stringbenchmarking.commons.exception.JMHRuntimeException;

public class ZuzSerializer {

	private static final AutoCloser AUTO_CLOSER = new AutoCloser();

	public static <T extends Serializable> File serializing(
		T o,
		File file) {
		try {
			OutputStream ouput = new FileOutputStream(file);
			try {
				ObjectOutputStream oStream = new ObjectOutputStream(ouput);
				try {
					oStream.writeObject(o);
					return file;
				} finally {
					AUTO_CLOSER.executeClose(oStream);
				}
			} finally {
				AUTO_CLOSER.executeClose(ouput);
			}
		} catch (Exception e) {
			throw new JMHRuntimeException(e);
		}
	}

	public static <T extends Serializable> T deserialization(
		File file) {
		try {
			FileInputStream in = new FileInputStream(file);
			try {
				ObjectInputStream oStream = new ObjectInputStream(in);
				try {
					return ZuzObjects.casting(oStream.readObject());
				} finally {
					AUTO_CLOSER.executeClose(oStream);
				}
			} finally {
				AUTO_CLOSER.executeClose(in);
			}
		} catch (Exception e) {
			throw new JMHRuntimeException(e);
		}
	}

	public static <T extends Serializable> byte[] serializing(
		T o) {
		try {
			ByteArrayOutputStream oStream = new ByteArrayOutputStream();
			try {
				ObjectOutputStream output = new ObjectOutputStream(oStream);
				try {
					output.writeObject(o);
					output.flush();
					return oStream.toByteArray();
				} finally {
					AUTO_CLOSER.executeClose(output);
				}
			} finally {
				AUTO_CLOSER.executeClose(oStream);
			}
		} catch (Exception e) {
			throw new JMHRuntimeException(e);
		}
	}

	public static <T extends Serializable> T deserialization(
		byte[] value) {
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(value);
			try {
				ObjectInputStream oStream = new ObjectInputStream(in);
				try {
					return ZuzObjects.casting(oStream.readObject());
				} finally {
					AUTO_CLOSER.executeClose(oStream);
				}
			} finally {
				AUTO_CLOSER.executeClose(in);
			}
		} catch (Exception e) {
			throw new JMHRuntimeException(e);
		}
	}
}
