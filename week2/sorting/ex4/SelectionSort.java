package vn.io.tunaa.dsa.week2.sorting.ex4;

import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        selectionSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}