package com.tctam.algorithms.graph;

import java.util.Scanner;

/* 
13
13
0 5
4 3
0 1
9 12
6 4
5 4
0 2
11 12
9 10
0 6
7 8
9 11
5 3 
**/
public class DepthFirstSearch implements Search {
	private int count;
	private boolean marked[];
	private Graph g;

	public DepthFirstSearch(Graph g, int s) {
		this.g = g;
		this.count = 0;
		this.marked = new boolean[g.V()];
		dfs(s);
	}

	private void dfs(int u) {
		count++;
		marked[u] = true;
		System.out.print(u + " -- ");
		for (int v : g.adj(u)) {
			if (!marked[v]) {
				dfs(v);
			}
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertices = in.nextInt();
		int edges = in.nextInt();
		Graph g = new UnidirectedAdjacentListGraph(vertices);
		for (int i = 0; i < edges; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			g.addEdge(u, v);
		}
		System.out.println(g.toString());
		Search search = new DepthFirstSearch(g, 0);
		System.out.println("\nNumber of connected vertices is " + search.count());
		in.close();
	}
}
