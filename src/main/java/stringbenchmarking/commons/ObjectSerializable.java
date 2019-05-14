package stringbenchmarking.commons;


public interface ObjectSerializable<T> {
	
	public String serializing(T o);
	
	public T deserialization(String value);
	
}
