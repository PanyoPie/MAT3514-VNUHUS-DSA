package vn.io.tunaa.dsa.exam_2425_2nd_endterm_2.ex2__check_cycle;

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

    // Phuong thuc kiem tra xem do thi co chu trinh hay khong
    public boolean hasCycle() {
        int[] parent = new int[n];
        Queue<Integer> queue = new LinkedList<>();
    
        queue.offer(0);
        visited[0] = true;
        parent[0] = -1;

        while (!queue.isEmpty()) {
            int i = queue.poll();

            for (int j : adj.get(i)) {
                if (!visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                    parent[j] = i;
                } else if (j != parent[i]) {	 	  	 		      	     		   	       	 	
                    return true;
                }
            }
        }

        return false;
    }
}
