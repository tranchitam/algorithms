package com.tctam.algorithms.queue;

public interface Queue<T> {
	public abstract void enqueue(T item);

	public abstract T dequeue();

	public boolean isEmpty();
}
