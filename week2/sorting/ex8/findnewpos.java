package vn.io.tunaa.dsa.week2.sorting.ex8;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class findnewpos {
    public static void insertionSort(int[] a, int[] pos) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int keyPos = pos[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                pos[j + 1] = pos[j];
                j--;
            }

            a[j + 1] = key;
            pos[j + 1] = keyPos;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("findnewpos.inp"));
        PrintWriter out = new PrintWriter("findnewpos.out");

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] a = new int[n];
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            pos[i] = i + 1;
        }

        insertionSort(a, pos);

        int newPos = -1;
        for (int i = 0; i < n; i++) {
            if (pos[i] == t) {
                newPos = i + 1;
                break;
            }
        }

        out.println(newPos);
        out.close();
        sc.close();
    }
}
