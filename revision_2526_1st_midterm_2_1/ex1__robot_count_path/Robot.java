package vn.io.tunaa.dsa.revision_2526_1st_midterm_2_1.ex1__robot_count_path;

import java.util.Scanner;

// Sinh viên hoàn thành phương thức countPath(int M, int N, int t)
public class Robot {
//    public static int factorial(int n) {
//        if (n == 0 || n == 1) {
//            return 1;
//        }
//
//        int result = 1;
//
//        for (int i = 2; i <= n; i++) {
//            result *= i;
//        }
//
//        return result;
//    }
//
//    static int combination(int k, int n) {
//        return (factorial(n)) / (factorial(k) * factorial(n - k));
//    }
//
//    public int countPath(int M, int N, int t) {
//        return (combination(t - 1, (t - 1) + (N - 1)) + combination(M - t - 1, (M - t - 1) + (N - 1))) % 1000000007;
//    }

    public int countPath(int M, int N, int t) {
        int[][] a = new int[N + 1][M + 1];

        for (int i = 1; i <= M; i++) {
            a[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = t; j >= 1; j--) {
                if (j == t) {
                    a[i][j] = a[i - 1][j];
                } else {
                    a[i][j] = a[i - 1][j] + a[i][j + 1];
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int j = t + 1; j <= M; j++) {
                if (j == t + 1) {
                    a[i][j] = a[i - 1][j];
                } else {
                    a[i][j] = a[i - 1][j] + a[i][j - 1];
                }
            }
        }

        // in cai bang ra nhin cho dep hjhj, btw index la 1
//        for (int[] row : a) {
//            for (int value : row) {
//                System.out.print(value + " ");
//            }
//
//            System.out.println();
//        }

        return a[N][1] + a[N][M];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int t = sc.nextInt();

        System.out.println((new Robot()).countPath(M, N, t));
    }
}
