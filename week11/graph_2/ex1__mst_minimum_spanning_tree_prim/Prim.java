package vn.io.tunaa.dsa.week11.graph_2.ex1__mst_minimum_spanning_tree_prim;

import java.util.*;

public class Prim {
    private int numVertices;
    private int[][] graph;

    /**
     * Khởi tạo đối tượng với ma trận kề của đồ thị.
     *
     * @param graph Ma trận kề thể hiện trọng số các cạnh. 9999 biểu thị không có cạnh.
     */
    public Prim(int[][] graph) {
        this.numVertices = graph.length;
        this.graph = graph;
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = 9999;
        int minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    /**
     * Thực hiện thuật toán Prim để tìm MST.
     *
     * @return mảng parent, trong đó parent[i] là đỉnh cha của đỉnh i trong MST.
     */
    public int[] primMST() {
        int[] key = new int[numVertices];
        int[] parent = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < numVertices - 1; i++) {	 	  	 		      	     		   	       	 	
            int u = minKey(key, visited);
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] != 0 &&
                        graph[u][v] != Integer.MAX_VALUE &&
                        !visited[v] &&
                        graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        return parent;
    }

}