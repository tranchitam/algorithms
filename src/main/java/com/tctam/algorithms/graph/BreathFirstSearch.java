package com.tctam.algorithms.graph;

import java.util.Scanner;
import java.util.Stack;

import com.tctam.algorithms.queue.LinkedQueue;
import com.tctam.algorithms.queue.Queue;

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
public class BreathFirstSearch implements Search {
	private int count;
	private boolean marked[];
	private int edgeTo[];
	private Graph g;
	private Queue<Integer> queue;
	private int s;

	public BreathFirstSearch(Graph g, int s) {
		this.g = g;
		this.count = 0;
		this.marked = new boolean[g.V()];
		this.edgeTo = new int[g.V()];
		this.queue = new LinkedQueue<Integer>();
		this.s = s;
		bfs(s);
	}

	private void bfs(int u) {
		queue.enqueue(u);
		while (!queue.isEmpty()) {
			Integer uu = queue.dequeue();
			if (!marked[uu]) {
				count++;
				marked[uu] = true;
				System.out.print(uu + "--");
				for (int v : g.adj(uu)) {
					if (!marked(v)) {
						edgeTo[v] = uu;
						queue.enqueue(v);
					}
				}
			}
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int count() {
		return count;
	}

	public boolean hasPath(int v) {
		return marked[v];
	}

	public Iterable<Integer> paths(int v) {
		if (!hasPath(v)) {
			return null;
		}

		Stack<Integer> paths = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			paths.push(x);
		}
		paths.push(s);
		return paths;
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
		int s = 0;
		Search search = new BreathFirstSearch(g, s);
		System.out.println("\nNumber of connected vertices from " + s + " is " + search.count());

		for (int i = 0; i < g.V(); i++) {
			System.out.println(String.format("Path %s to %s is %s", i, s, search.paths(i)));
		}
		in.close();
	}

}
