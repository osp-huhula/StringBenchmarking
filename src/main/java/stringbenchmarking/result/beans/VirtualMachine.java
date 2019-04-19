package stringbenchmarking.result.beans;

import java.io.File;

import stringbenchmarking.result.converter.line.beans.VMVersionLine;

public class VirtualMachine {

	private String jdkVersion;
	private String vmVersion;
	private File vmInvoker;
	private String vmOptions;

	public String getJdkVersion() {
		return jdkVersion;
	}

	public void setJdkVersion(
		String jdkVersion) {
		this.jdkVersion = jdkVersion;
	}

	public String getVmVersion() {
		return vmVersion;
	}

	public void setVmVersion(
		String vmVersion) {
		this.vmVersion = vmVersion;
	}

	public void setVMVersion(
		VMVersionLine vmVersion) {
		this.vmVersion = vmVersion.getVmVersion();
		this.jdkVersion = vmVersion.getJdkVersion();
	}

	public File getVMInvoker() {
		return vmInvoker;
	}

	public void setVMInvoker(
		File invoker) {
		this.vmInvoker = invoker;
	}

	public void setVMOptions(
		String vmOptions) {
		this.vmOptions = vmOptions;
	}

	public String getVMOptions() {
		return this.vmOptions;
	}
}
