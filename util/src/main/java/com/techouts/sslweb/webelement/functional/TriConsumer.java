package com.techouts.sslweb.webelement.functional;

/**
 * @author sairam.p
 */
@FunctionalInterface
public interface TriConsumer<T, U, V> {

	public abstract void consume(T t, U u,V v);
}
