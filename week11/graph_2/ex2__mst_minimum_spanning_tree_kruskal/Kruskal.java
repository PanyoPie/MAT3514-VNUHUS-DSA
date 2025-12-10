package vn.io.tunaa.dsa.week11.graph_2.ex2__mst_minimum_spanning_tree_kruskal;

import java.util.*;

class Kruskal {
    int V;
    List<Edge> edges;

    Kruskal(int vertices, List<List<Graph.Pair>> adjList) { // khởi tạo class, chuyển adjList sang danh sách cạnh
        V = vertices;

        Graph graph = new Graph(V);
        for (int i = 0; i < V; i++) {
            for (Graph.Pair p : adjList.get(i)) {
                graph.addEdge(i, p.vertex, p.weight);
            }
        }

        edges = graph.getAllEdges();
    }

    private boolean checkCycle(List<List<Integer>> adjList, boolean[] visited, int src, int dest) {
        if (src == dest) return true;

        visited[src] = true;

        for (int i : adjList.get(src)) {
            if (!visited[i]) {
                if (checkCycle(adjList, visited, i, dest)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void kruskalMST() {
        Collections.sort(edges);

        List<Edge> result = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {	 	  	 		      	     		   	       	 	
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            if (!checkCycle(adjList, new boolean[V], edge.src, edge.dest)) {
                result.add(edge);
                adjList.get(edge.src).add(edge.dest);
                adjList.get(edge.dest).add(edge.src);

                if (result.size() == V - 1) {
                    break;
                }
            }
        }

        System.out.println("Các cạnh trong Minimum Spanning Tree:");
        for (Edge edge : result) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
    }
}
