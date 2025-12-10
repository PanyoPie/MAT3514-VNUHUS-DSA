package vn.io.tunaa.dsa.week2.sorting.ex4;

import java.util.Scanner;

public class SapXepDaySo {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] b = new int[1000001];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] != 0) {
                b[count] = arr[i];
                count++;
            }
        }

        int[] c = new int[count];
        for (int i = 0; i < count; i++) {
            c[i] = b[i];
        }
        insertionSort(c);

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 0) {
                arr[i] = c[count];
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                arr[i] = c[count];
                count++;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
