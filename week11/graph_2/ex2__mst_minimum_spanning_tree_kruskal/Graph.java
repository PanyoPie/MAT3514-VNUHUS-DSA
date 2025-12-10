package vn.io.tunaa.dsa.week11.graph_2.ex2__mst_minimum_spanning_tree_kruskal;

import java.util.*;

/**
 * Lớp đại diện một cạnh trong đồ thị.
 */
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

/**
 * Lớp đồ thị sử dụng danh sách kề.
 */
class Graph {
    int V; // Số đỉnh
    List<List<Pair>> adjList; // Danh sách kề

    // Lớp phụ để lưu cặp đỉnh và trọng số
    class Pair {
        int vertex, weight;

        Pair(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    Graph(int v) {	 	  	 		      	     		   	       	 	
        V = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());
    }

    /**
     * Thêm cạnh vào danh sách kề (đồ thị vô hướng).
     */
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Pair(v, weight));
        adjList.get(v).add(new Pair(u, weight)); // Vì đồ thị vô hướng
    }

    /**
     * Trích xuất danh sách cạnh từ danh sách kề (không lặp cạnh).
     */
    public List<Edge> getAllEdges() {
        List<Edge> edges = new ArrayList<>();
        boolean[][] visited = new boolean[V][V];

        for (int u = 0; u < V; u++) {
            for (Pair p : adjList.get(u)) {
                int v = p.vertex;
                if (!visited[u][v]) {
                    edges.add(new Edge(u, v, p.weight));
                    visited[u][v] = true;
                    visited[v][u] = true;
                }
            }
        }
        return edges;
    }
}	 	  	 		      	     		   	       	 	
