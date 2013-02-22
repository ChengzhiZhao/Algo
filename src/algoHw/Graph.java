package algoHw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Graph {
	private final int V;
	private Map<Integer, Vertex> adj;;
	private Set<Edge> edges = new HashSet<Edge>();

	private static class Vertex {
		private int lbl;
		private ArrayList<Integer> adjv;

		public Vertex(int lbl) {
			this.lbl = lbl;
			adjv = new ArrayList<Integer>();
		}

		public void addV(int v2) {
			adjv.add(v2);
		}

		public void rmV(int v2) {
			for (int i = 0; i < adjv.size(); ++i) {
				if (adjv.get(i) == v2) {
					adjv.remove(i);
					return;
				}
			}
		}

		public String toString() {
			return adjv.toString();
		}
	}

	static class Edge {
		private int first;
		private int second;

		public Edge(int f, int s) {
			first = f;
			second = s;
		}

		public boolean contains(int f, int s) {
			return (f == first && s == second);
		}

		public String toString() {
			return new String(first + "-" + second);
		}

		public boolean equals(Object c) {
			Edge other = (Edge) c;
			return (other.first == this.first && other.second == this.second)
					|| (other.second == this.first && other.first == this.second);
		}

		public int hashCode() {
			int max = Math.max(first, second);
			int min = Math.min(first, second);
			return max * 31 + min;
		}
	}

	public Graph(int[][] arr) {
		V = arr.length;
		adj = new TreeMap<Integer, Vertex>();
		for (int[] row : arr) {
			if (row != null) {
				for (int i = 1; i < row.length; ++i) {
					addEdge(row[0], row[i]);
				}
			}
		}
	}

	public int V() {
		return V;
	}

	public void addEdge(int v, int w) {
		if (adj.get(v) == null) {
			adj.put(v, new Vertex(v));
		}
		adj.get(v).addV(w);
		Edge e = new Edge(v, w);
		if (!edges.contains(e)) {
			edges.add(e);
		}
	}

	public Vertex adj(int v) {
		return adj.get(v);
	}

	public void rmEdge(int v, int w) {
		if (!edges.contains(new Edge(v, w)))
			throw new IllegalArgumentException("invalid edge");
		edges.remove(new Edge(v, w));
		Vertex lv = adj.get(v);
		lv.rmV(w);
		Vertex lw = adj.get(w);
		lw.rmV(v);
	}

	public void fuse(int from, int to) {
	}

	public String toString() {
		StringBuffer str = new StringBuffer("V: " + V + " E: " + edges.size()
				+ "\n");
		for (Map.Entry<Integer, Vertex> entry : adj.entrySet()) {
			int v = entry.getKey();
			Vertex list = entry.getValue();
			str.append(v + ": " + list.toString() + "\n");
		}
		str.append(edges.toString());
		return str.toString();
	}

	public static void main(String[] args) {
		int[][] input = { { 1, 2, 5, 6 }, { 2, 1, 5, 6, 3 }, { 3, 2, 4, 7, 8 },
				{ 4, 3, 7, 8 }, { 5, 1, 2, 6 }, { 6, 1, 2, 5, 7 },
				{ 7, 3, 6, 8, 4 }, { 8, 3, 4, 7 } };
		Graph g = new Graph(input);
		// System.out.println(g.toString());
		// g.rmEdge(new Edge(1, 5));
		g.rmEdge(1, 5);
		// g.addEdge(2, 5);
		// g.addEdge(5, 6);
		// g.replace(1, 5);
		System.out.println(g.toString());

	}

}
