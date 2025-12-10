package vn.io.tunaa.dsa.week10.graph_1.ex5__dijkstra;

import java.util.*;

public class Graph {

    public int[] djikstra(int[][] a, int x, int y) {
        int n = a.length;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        int[] trace = new int[n];
        Arrays.fill(trace, -1);

        boolean[] visited = new boolean[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> dist[i]));
        pq.add(x);

        while (!pq.isEmpty()) {
            int u = pq.poll();

            if (visited[u]) continue;
            visited[u] = true;

            if (u == y) break;

            for (int v = 0; v < n; v++) {
                if (a[u][v] > 0 && !visited[v]) {
                    if (dist[u] + a[u][v] < dist[v]) {
                        dist[v] = dist[u] + a[u][v];
                        trace[v] = u;
                        pq.offer(v);
                    }
                }
            }
        }	 	  	 		      	     		   	       	 	

        if (dist[y] == Integer.MAX_VALUE) {
            return new int[] {};
        }

        List<Integer> pathList = new ArrayList<>();
        int current = y;

        while (current != -1) {
            pathList.add(current);
            current = trace[current];
        }

        Collections.reverse(pathList);

        return pathList.stream().mapToInt(i -> i).toArray();
    }
}