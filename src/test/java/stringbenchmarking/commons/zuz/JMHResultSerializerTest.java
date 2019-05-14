package stringbenchmarking.commons.zuz;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.io.JMHResultSerializer;
import stringbenchmarking.result.beans.Fork;
import stringbenchmarking.result.beans.IterationMeasure;
import stringbenchmarking.result.beans.JMHBenchmarkResult;
import stringbenchmarking.result.beans.JMHResultImp;
import stringbenchmarking.result.beans.Measurement;
import stringbenchmarking.result.beans.RunProgressSummary;
import stringbenchmarking.result.beans.VirtualMachine;
import stringbenchmarking.result.beans.Warmup;
import stringbenchmarking.result.beans.WarmupMeasure;

public class JMHResultSerializerTest {

	@Test
	public void testSerializingAndDeserializationEmpty() {
		byte[] serializing = JMHResultSerializer.serializing(new JMHResultImp());
		JMHResultImp deserialization = JMHResultSerializer.deserialization(serializing);
		Assert.assertEquals(new JMHResultImp(), deserialization);
	}

	@Test
	public void testSerializingAndDeserialization() {
		byte[] serializing = JMHResultSerializer.serializing(vDefault());
		JMHResultImp deserialization = JMHResultSerializer.deserialization(serializing);
		Assert.assertEquals(vDefault(), deserialization);
	}

	private JMHResultImp vDefault() {
		JMHResultImp result = new JMHResultImp();
		result.setVirtualMachine(new VirtualMachine());
		result.setWarmup(new Warmup());
		result.setMeasurement(new Measurement());
		result.setRunProgressSummary(new RunProgressSummary());
		result.setFork(new Fork());
		result.add(new JMHBenchmarkResult());
		result.addIterationMeasure(new IterationMeasure());
		result.addWarmupMeasure(new WarmupMeasure());
		return result;
	}
}
