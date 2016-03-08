package com.tctam.algorithms.unionfind;

public class QuickUnion extends AbstractUnionFind {

	public QuickUnion(int numberOfElements) {
		super(numberOfElements);
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (i != j) {
			id[i] = j;
			numberOfComponents--;
		}

	}

	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	public static void main(String[] args) {
		UnionFind qf = new QuickUnion(10);
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
