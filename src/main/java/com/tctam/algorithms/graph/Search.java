package com.tctam.algorithms.graph;

public interface Search {
	public abstract boolean marked(int v);

	public abstract int count();

	public boolean hasPath(int v);

	public Iterable<Integer> paths(int v);
}
