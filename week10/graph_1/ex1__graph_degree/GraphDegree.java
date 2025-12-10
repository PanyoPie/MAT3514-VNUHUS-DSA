package vn.io.tunaa.dsa.week10.graph_1.ex1__graph_degree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@SuppressWarnings({"unchecked", "deprecation"})
public class GraphDegree {

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

    public int[] getDegree() {
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {	 	  	 		      	     		   	       	 	
                if (matrix[i][j] == 1) {
                    count++;
                }
            }

            degree[i] = count;
        }

        return degree;
    }
}