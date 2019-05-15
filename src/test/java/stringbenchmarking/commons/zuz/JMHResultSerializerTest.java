package stringbenchmarking.commons.zuz;

import org.junit.Assert;
import org.junit.Test;

import stringbenchmarking.io.JMHResultSerializer;
import stringbenchmarking.result.beans.JMHBenchmarkResult;
import stringbenchmarking.result.beans.JMHResult;
import stringbenchmarking.result.beans.JMHResultImp;

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
	
	@Test
	public void testSerializingAndDeserializationAsInterface() {
		byte[] serializing = JMHResultSerializer.serializing(vDefaultAsJMHResult());
		JMHResultImp deserialization = JMHResultSerializer.deserialization(serializing);
		Assert.assertEquals(vDefaultAsJMHResult(), deserialization);
	}

	private JMHResult vDefaultAsJMHResult() {
		return vDefault();
	}
	private JMHResultImp vDefault() {
		JMHResultImp result = new JMHResultImp();
//		result.setVirtualMachine(new VirtualMachine());
//		result.setWarmup(new Warmup());
//		result.setMeasurement(new Measurement());
//		result.setRunProgressSummary(new RunProgressSummary());
//		result.add(new Fork());
		result.add(new JMHBenchmarkResult());
//		result.addIterationMeasure(new IterationMeasure());
//		result.addWarmupMeasure(new WarmupMeasure());
		return result;
	}
}
