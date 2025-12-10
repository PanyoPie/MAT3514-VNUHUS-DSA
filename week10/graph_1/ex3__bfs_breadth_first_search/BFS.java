package vn.io.tunaa.dsa.week10.graph_1.ex3__bfs_breadth_first_search;

import java.io.*;
import java.util.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class BFS {
    public static List<List<Integer>> readGraphFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new FileReader(fileName));

            int n = Integer.parseInt(sc.nextLine());
            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                matrix.add(new ArrayList<>(n));
                String[] line = sc.nextLine().split(" +");

                for (int j = 1; j < line.length; j++) {
                    matrix.get(i).add(Integer.parseInt(line[j]));
                }
            }

            sc.close();

            return matrix;
        } catch (FileNotFoundException ignored) {}

        return null;
    }

    public void bfs(List<List<Integer>> adjList, int start) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {	 	  	 		      	     		   	       	 	
            int u = queue.poll();

            System.out.print(u + " ");

            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
//        {[1, 2], [0, 2, 3], [0, 1, 3], [1, 2]]
        List<List<Integer>> a = new ArrayList<>();

        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        a.add(tmp);

        tmp = new ArrayList<>();
        tmp.add(0);
        tmp.add(2);
        tmp.add(3);
        a.add(tmp);

        tmp = new ArrayList<>();
        tmp.add(0);
        tmp.add(1);
        tmp.add(3);
        a.add(tmp);

        tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        a.add(tmp);

        System.out.println(a);
        (new BFS()).bfs(a, 0);
    }	 	  	 		      	     		   	       	 	
}
