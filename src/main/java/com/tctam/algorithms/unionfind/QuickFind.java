package com.tctam.algorithms.unionfind;

public class QuickFind extends AbstractUnionFind {

	public QuickFind(int numberOfElements) {
		super(numberOfElements);
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		if (!connected(p, q)) {
			int pValue = id[p];
			for (int i = 0; i < id.length; i++) {
				if (id[i] == pValue) {
					id[i] = id[q];
				}
			}
			numberOfComponents--;
		}
	}

	public static void main(String[] args) {
		UnionFind qf = new QuickFind(10);
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
