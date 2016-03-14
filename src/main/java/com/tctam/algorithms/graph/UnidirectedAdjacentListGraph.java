package com.tctam.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
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

@SuppressWarnings("unchecked")
public class UnidirectedAdjacentListGraph implements Graph {
	private int vertices;
	private int edges;
	private List<Integer> adjacentLists[];

	public UnidirectedAdjacentListGraph(int v) {
		this.vertices = v;
		this.edges = 0;
		this.adjacentLists = (ArrayList<Integer>[]) new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adjacentLists[i] = new ArrayList<Integer>();
		}
	}

	public int V() {
		return vertices;
	}

	public int E() {
		return edges;
	}

	public Iterable<Integer> adj(int v) {
		return adjacentLists[v];
	}

	public void addEdge(int u, int v) {
		List<Integer> uList = adjacentLists[u];
		List<Integer> vList = adjacentLists[v];
		if (!uList.contains(v)) {
			edges++;
			uList.add(v);
			vList.add(u);
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(vertices + " vertices, " + edges + " edges\n");
		for (int i = 0; i < vertices; i++) {
			s.append(i + ": ");
			for (int list : adjacentLists[i]) {
				s.append(list + " ");
			}
			s.append("\n");
		}
		return s.toString();
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
		in.close();
	}
}
