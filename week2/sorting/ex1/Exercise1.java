package vn.io.tunaa.dsa.week2.sorting.ex1;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    private static int mergeSortSwapCount = 0;
    private static int mergeSortCompareCount = 0;
    private static int quickSortSwapCount = 0;
    private static int quickSortCompareCount = 0;

    public static void main(String[] args) {
        testInput();
        testRandom();
    }

    private static int[] inputArray() {
        System.out.print("Nhập kích thước mảng: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.print("Nhập vào mảng: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        return a;
    }

    private static int[] randomArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(1, 100000 + 1);
        }

        return a;
    }

    private static String outputArray(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int i : a) {
            sb.append(i).append(" ");
        }

        return sb.toString();
    }

    private static double time(long start, long end) {
        return (double) (end - start) / Math.pow(10, 9);
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void testInput() {
        int[] a = inputArray();

        int[] tmp1 = a.clone();
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println("Mảng ban đầu: " + outputArray(tmp1));
        bubbleSort(tmp1);
        System.out.println("Mảng sau khi sắp xếp: " + outputArray(tmp1));

        int[] tmp2 = a.clone();
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println("Mảng ban đầu: " + outputArray(tmp2));
        selectionSort(tmp2);
        System.out.println("Mảng sau khi sắp xếp: " + outputArray(tmp2));

        int[] tmp3 = a.clone();
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println("Mảng ban đầu: " + outputArray(tmp3));
        insertionSort(tmp3);
        System.out.println("Mảng sau khi sắp xếp: " + outputArray(tmp3));

        int[] tmp4 = a.clone();
        System.out.println();
        System.out.println("Merge Sort");
        System.out.println("Mảng ban đầu: " + outputArray(tmp4));
        mergeSort(tmp4, 0, tmp4.length - 1);
        System.out.println("Mảng sau khi sắp xếp: " + outputArray(tmp4));

        int[] tmp5 = a.clone();
        System.out.println();
        System.out.println("Quick Sort");
        System.out.println("Mảng ban đầu: " + outputArray(tmp5));
        quickSort(tmp5, 0, tmp5.length - 1);
        System.out.println("Mảng sau khi sắp xếp: " + outputArray(tmp5));
    }

    public static void testRandom() {
        int[] nArray = {100, 1000, 10000, 100000};
        int[] rArray;
        long startTime;
        for (int i : nArray) {
            rArray = randomArray(i);

            System.out.println("=======================================");

            System.out.println("n = " + i);

            System.out.println();
            System.out.println("Merge Sort");
            startTime = System.nanoTime();
            mergeSort(rArray.clone(), 0, rArray.length - 1);
            System.out.printf("Thời gian chạy : %.6fs\n", time(startTime, System.nanoTime()));

            System.out.println();
            System.out.println("Quick Sort");
            startTime = System.nanoTime();
            quickSort(rArray.clone(), 0, rArray.length - 1);
            System.out.printf("Thời gian chạy : %.6fs\n", time(startTime, System.nanoTime()));

            System.out.println();
            System.out.println("Bubble Sort");
            startTime = System.nanoTime();
            bubbleSort(rArray.clone());
            System.out.printf("Thời gian chạy : %.6fs\n", time(startTime, System.nanoTime()));

            System.out.println();
            System.out.println("Selection Sort");
            startTime = System.nanoTime();
            selectionSort(rArray.clone());
            System.out.printf("Thời gian chạy : %.6fs\n", time(startTime, System.nanoTime()));

            System.out.println();
            System.out.println("Insertion Sort");
            startTime = System.nanoTime();
            insertionSort(rArray.clone());
            System.out.printf("Thời gian chạy : %.6fs\n", time(startTime, System.nanoTime()));
        }
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        long compareCount = 0, swapCount = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    swap(a, j, j + 1);
                    swapCount++;
                    swapped = true;

                    if (a.length <= 10) {
                        System.out.println(outputArray(a));
                    }
                }
                compareCount++;
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println("Số lần so sánh : " + compareCount);
        System.out.println("Số lần swap    : " + swapCount);
    }

    public static void selectionSort(int[] a) {
        int n = a.length;
        long compareCount = 0, swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                    swapCount++;

                    if (a.length <= 10) {
                        System.out.println(outputArray(a));
                    }
                }
                compareCount++;
            }
        }

        System.out.println("Số lần so sánh : " + compareCount);
        System.out.println("Số lần swap    : " + swapCount);
    }

    public static void insertionSort(int[] a) {
        int n = a.length;
        long compareCount = 0, swapCount = 0;

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
                compareCount += 2;
                swapCount++;

                if (a.length <= 10) {
                    System.out.println(outputArray(a));
                }
            }

            a[j + 1] = key;
        }

        System.out.println("Số lần so sánh : " + compareCount);
        System.out.println("Số lần swap    : " + swapCount);
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(a, l, left, 0, n1);
        System.arraycopy(a, mid + 1, right, 0, n2);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }

            k++;

            mergeSortCompareCount++;
            mergeSortSwapCount++;
        }

        while (i < n1) {
            a[k] = left[i];
            i++;
            k++;
            mergeSortSwapCount++;
        }

        while (j < n2) {
            a[k] = right[j];
            j++;
            k++;
            mergeSortSwapCount++;
        }
    }

    private static void mergeSortRecursive(int[] a, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;

            mergeSortRecursive(a, l, mid);
            mergeSortRecursive(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    public static void mergeSort(int[] a, int l, int r) {
        mergeSortSwapCount = 0;
        mergeSortCompareCount = 0;

        mergeSortRecursive(a, l, r);

        System.out.println("Số lần so sánh : " + mergeSortSwapCount);
        System.out.println("Số lần swap    : " + mergeSortCompareCount);
    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];

        int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;

                quickSortSwapCount++;
            }
            quickSortCompareCount++;
        }

        swap(a, i, r);
        return i;
    }

    private static void quickSortRecursive(int[] a, int l, int r) {
        if (l < r) {
            int pivot = partition(a, l, r);

            quickSortRecursive(a, l, pivot - 1);
            quickSortRecursive(a, pivot + 1, r);
        }
    }

    public static void quickSort(int[] a, int l, int r) {
        quickSortSwapCount = 0;
        quickSortCompareCount = 0;

        quickSortRecursive(a, l, r);

        System.out.println("Số lần so sánh : " + quickSortSwapCount);
        System.out.println("Số lần swap    : " + quickSortCompareCount);
    }
}
