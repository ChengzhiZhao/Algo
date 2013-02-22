package algoHw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Graph {
	private final int V;
	private Map<Integer, Vertex> adj = new TreeMap<Integer, Vertex>();
	private Set<Edge> edges = new HashSet<Edge>();

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
		
		public boolean equals(Object c){
			Edge other = (Edge)c;
			return (other.first == this.first && other.second == this.second) || 
					(other.second == this.first && other.first == this.second);
		}
		public int hashCode(){
			int max = Math.max(first, second);
			int min = Math.min(first, second);
			return max*31 + min;
		}
	}

	public Graph(int[][] arr) {
		V = arr.length;
		for (int[] row : arr) {
			if (row != null) {
				Vertex thisRow = new Vertex(row);
				adj.put(row[0], thisRow);
				for(int edgeTo: thisRow.adjv){
					Edge e = new Edge(row[0], edgeTo);
					if (!edges.contains(e)){
						edges.add(new Edge(row[0], edgeTo));
					}
				}
			}
		}
	}

	public int V() {
		return V;
	}
	
	public void addEdge(int v, int w) {
		adj.get(v).addV(w);
	}

	public Vertex adj(int v) {
		return adj.get(v);
	}
	
	public void rmEdge(Edge e){
		edges.remove(e);
	}
	public void replace(int from, int to){
		Vertex fixingIndex = adj.get(from);
		for(int i: fixingIndex.adjv){
			adj.get(i).replace(from, to);
		}
		Vertex adding = adj.get(from);
		for(int i: adding.adjv){
			adj.get(to).addV(i);
			System.out.println();
		}
		for(int i: adj.get(to){
			if(i == to){
				adj.remove(i);
			}
		}
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

	private static class Vertex {
		private final int lbl;
		private ArrayList<Integer> adjv;

		public Vertex(int lbl) {
			this.lbl = lbl;
			adjv = new ArrayList<Integer>();
		}

		public void replace(int from, int to) {
			// TODO Auto-generated method stub
//			for(int i: adjv){
//				if(i == from){
//					adjv.remove(i);
//					if(to != lbl) adjv.add(to);
//				}
//			}
			for(int i=0; i < adjv.size(); ++i){
				if(adjv.get(i) == from){
					adjv.remove(i);
//					if(to != lbl) 
					adjv.add(to);
				}
			}
		}

		public boolean contains(int i) {
			// TODO Auto-generated method stub
			return adjv.contains(i);
		}

		public Vertex(int[] arr) {
			this(arr[0]);
			for (int i = 1; i < arr.length; ++i) {
				adjv.add(arr[i]);
			}
		}

		public void addV(int v2) {
			adjv.add(v2);
		}

		public String toString() {
			return adjv.toString();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = { { 1, 2, 5, 6 }, { 2, 1, 5, 6, 3 }, { 3, 2, 4, 7, 8 },
				{ 4, 3, 7, 8 }, { 5, 1, 2, 6 }, { 6, 1, 2, 5, 7 },
				{ 7, 3, 6, 8, 4 }, { 8, 4, 7 } };
		Graph g = new Graph(input);
//		System.out.println(g.toString());
//		g.rmEdge(new Edge(1, 5));
		g.rmEdge(new Edge(1, 5));
//		g.addEdge(2, 5);
//		g.addEdge(5, 6);
		g.replace(1, 5);
		System.out.println(g.toString());

	}

}
