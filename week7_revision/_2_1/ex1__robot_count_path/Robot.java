package vn.io.tunaa.dsa.week7_revision._2_1.ex1__robot_count_path;

// Sinh viên hoàn thành phương thức countPath(int M, int N, int t)
public class Robot {
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
        System.out.println((new Robot()).countPath(6, 6, 2));
    }
}
