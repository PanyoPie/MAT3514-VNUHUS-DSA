package vn.io.tunaa.dsa.week2.sorting.ex6;

import java.util.Arrays;
import java.util.Scanner;

public class capdoi {
    private static int first(int[] arr, int right, int key) {
        int l = 0, r = right, a = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == key) {
                a = mid;
                r = mid - 1;
            } else if (arr[mid] < key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return a;
    }

    private static int last(int[] arr, int right, int key) {
        int l = 0, r = right, a = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == key) {
                a = mid;
                l = mid + 1;
            } else if (arr[mid] < key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return a;
    }

    private static void cach1(int[] arr, int n, int x) {
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == x) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void cach2(int[] arr, int n, int x) {
        Arrays.sort(arr);

        int count = 0;
        for (int j = 1; j < n; j++) {
            int b = x - arr[j];

            int i1 = first(arr, j - 1, b);
            if (i1 != -1) {
                int i2 = last(arr, j - 1, b);
                count += (i2 - i1 + 1);
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        cach1(arr, n, x);
        cach2(arr, n, x);
    }
}
