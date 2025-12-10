package vn.io.tunaa.dsa.week2.sorting.ex4;

import java.util.Scanner;

public class DaySoChinhPhuong {
    public static void insertionSort(int[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }

    private static boolean check(int n) {
        int k = (int) Math.sqrt(n);
        return (k * k == n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        int[] b = new int[100001];

        for (int i = 0; i < n; i++){
            if (check(arr[i])){
                b[count] = arr[i];
                count++;
            }
        }

        int[] c = new int[count];
        for (int i = 0; i < count; i++) {
            c[i] = b[i];
        }

        insertionSort(c);

        if (count == 0) {
            System.out.println("NULL");
        } else {
            System.out.print(c[0] + " ");
            for (int i = 1; i < count; i++) {
                if (c[i] != c[i - 1]) {
                    System.out.print(c[i] + " ");
                }
            }
        }
    }
}
