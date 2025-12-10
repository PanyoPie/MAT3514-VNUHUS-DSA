package vn.io.tunaa.dsa.week2.sorting.ex4;

import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int[] a) {
        int temp, n = a.length;
        boolean swapped;

        for (int i = n - 1; i >= 1; i--) {
            swapped = false;

            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        bubbleSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}