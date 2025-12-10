package vn.io.tunaa.dsa.week10.graph_1.ex2__adjacent_matrix_and_list;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"unchecked", "deprecation"})
public class AdjMatrix {

    private int[][] matrix; // ma trận kề
    private String[] v;     // danh sách các đỉnh
    private int n;          // số đỉnh

    public void loadGraphFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new FileReader(fileName));

            n = sc.nextInt();
            v = new String[n];
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                v[i] = sc.next();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            sc.close();
        } catch (FileNotFoundException ignored) {}
    }

    public List<String> getAdjList() {
        List<String> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {	 	  	 		      	     		   	       	 	
            StringBuilder sb = new StringBuilder();
            sb.append(v[i]);

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    sb.append("->").append(v[j]);
                }
            }

            adjList.add(sb.toString());
        }

        return adjList;
    }
}
