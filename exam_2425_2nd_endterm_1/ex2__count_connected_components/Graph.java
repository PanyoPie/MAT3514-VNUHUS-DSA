package vn.io.tunaa.dsa.exam_2425_2nd_endterm_1.ex2__count_connected_components;

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

    private void dfs(int i) {
        if (visited[i]) return;

        visited[i] = true;
        for (int j : adj.get(i)) {
            if (!visited[j]) {
                dfs(j);
            }
        }
    }

    // Phuong thuc dem so thanh phan lien thong trong do thi
    public int countConnectedComponents() {
        int count = 0;

        for (int i = 0; i < n; i++) {	 	  	 		      	     		   	       	 	
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        return count;
    }
}
