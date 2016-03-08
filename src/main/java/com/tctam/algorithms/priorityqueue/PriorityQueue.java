package com.tctam.algorithms.priorityqueue;

public interface PriorityQueue<T extends Comparable<T>> {
	public abstract void insert(T key);

	public abstract boolean isEmpty();

	public abstract T deleteMax();
}