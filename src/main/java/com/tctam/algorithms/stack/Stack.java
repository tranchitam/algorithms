package com.tctam.algorithms.stack;

public interface Stack<T> {
	public abstract void push(T item);

	public abstract T pop();

	public boolean isEmpty();
}