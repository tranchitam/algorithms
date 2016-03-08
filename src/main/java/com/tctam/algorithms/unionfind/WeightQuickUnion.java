package com.tctam.algorithms.unionfind;

public class WeightQuickUnion extends AbstractUnionFind {

	private int size[];

	public WeightQuickUnion(int numberOfElements) {
		super(numberOfElements);
		size = new int[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			size[i] = 1;
		}
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (i != j) {
			int sizeI = size[i];
			int sizeJ = size[j];
			if (sizeJ >= sizeI) {
				id[i] = j;
				size[j] += size[i];
			} else {
				id[j] = i;
				size[i] += size[j];
			}
			numberOfComponents--;
		}
	}

	public static void main(String[] args) {
		UnionFind qf = new WeightQuickUnion(10);
		System.out.println(qf.toString());

		// Connect 0,1
		qf.union(0, 1);
		System.out.println(qf.toString());

		// Connect 4,5
		qf.union(4, 5);
		System.out.println(qf.toString());

		// Connect 9,7
		qf.union(9, 7);
		System.out.println(qf.toString());

		// Connect 6,4
		qf.union(6, 4);
		System.out.println(qf.toString());

		// Connect 0, 9
		qf.union(0, 9);
		System.out.println(qf.toString());

		// Connect 2, 3
		qf.union(2, 3);
		System.out.println(qf.toString());

		// Connect 4, 3
		qf.union(4, 3);
		System.out.println(qf.toString());

		// Connect 8, 9
		qf.union(8, 9);
		System.out.println(qf.toString());

		// Connect 0, 3
		qf.union(0, 3);
		System.out.println(qf.toString());
	}
}
