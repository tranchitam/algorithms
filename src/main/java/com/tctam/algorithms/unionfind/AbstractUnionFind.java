package com.tctam.algorithms.unionfind;

import java.util.Arrays;

public abstract class AbstractUnionFind implements UnionFind {
	protected int numberOfComponents;
	protected int[] id;

	public AbstractUnionFind(int numberOfElements) {
		numberOfComponents = numberOfElements;
		id = new int[numberOfElements];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	public int getNumberOfComponents() {
		return numberOfComponents;
	}

	@Override
	public String toString() {
		String s = "Number of components: " + numberOfComponents;
		s += ", array: " + Arrays.toString(id);
		return s;
	}
}
