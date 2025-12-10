package vn.io.tunaa.dsa.week11.graph_2.ex3__count_connected_components;

import java.util.*;

@SuppressWarnings({"unchecked", "deprecation"})
class Graph{
    private List<List<Integer>> adj;
    private boolean[] visited;
    private int n;

    public Graph(int n) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[n];
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Phuong thuc dem so thanh phan lien thong trong do thi
    public int countConnectedComponents() {
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                c++;
            }
        }

        return c;
    }

    private void dfs(int index) {	 	  	 		      	     		   	       	 	
        if (visited[index]) return;

        visited[index] = true;

        for (int v : adj.get(index)) {
            if (!visited[v]) dfs(v);
        }
    }
}
