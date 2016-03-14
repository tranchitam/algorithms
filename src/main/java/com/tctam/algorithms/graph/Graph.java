package com.tctam.algorithms.graph;

public interface Graph {
	public abstract int V();

	public abstract int E();

	public Iterable<Integer> adj(int v);

	public void addEdge(int u, int v);
}
