package com.tctam.algorithms.unionfind;

public interface UnionFind {
	public abstract boolean connected(int p, int q);

	public abstract void union(int p, int q);

	public abstract int getNumberOfComponents();
}
