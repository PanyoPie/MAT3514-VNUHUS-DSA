package vn.io.tunaa.dsa.week10.graph_1.ex4__dfs_depth_first_search;

import java.util.*;

class DFS {
    public void DFS(List<List<Integer>> adjList, int start) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (!visited[u]) {
                visited[u] = true;

                System.out.print(u + " ");

                List<Integer> neighbors = adjList.get(u);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int v = neighbors.get(i);
                    
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }
}	 	  	 		      	     		   	       	 	
