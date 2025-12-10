package vn.io.tunaa.dsa.week2.sorting.ex2;

import java.util.Arrays;

public class SortComparable {
    public static <T extends Comparable<T>> void bubbleSort(T[] a) {
        int n = a.length;
        boolean swapped;

        for (int i = n - 1; i >= 1; i--) {
            swapped = false;

            for (int j = 0; j < i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            T key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i].compareTo(a[j]) > 0) {
                    T temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    private static <T extends Comparable<T>> void merge(T[] a, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        T[] left = Arrays.copyOfRange(a, l, mid + 1);
        T[] right = Arrays.copyOfRange(a, mid + 1, r + 1);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i].compareTo(right[j]) <= 0) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            a[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] a, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;

            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    private static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static <T extends Comparable<T>> int partition(T[] a, int l, int r) {
        T pivot = a[r];

        int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (a[j].compareTo(pivot) < 0) {
                swap(a, i, j);
                i++;
            }
        }

        swap(a, i, r);

        return i;
    }

    public static <T extends Comparable<T>> void quickSort(T[] a, int l, int r) {
        if (l < r) {
            int pivot = partition(a, l, r);

            quickSort(a, l, pivot - 1);
            quickSort(a, pivot + 1, r);
        }
    }
}
