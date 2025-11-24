package vn.io.tunaa.dsa.week7.revision._2_2.ex1__robot_count_path;

// Sinh viên hoàn thành phương thức countPath(int M, int N, int t)
public class Robot {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    static int combination(int k, int n) {
        return (factorial(n)) / (factorial(k) * factorial(n - k));
    }

    public int countPath(int M, int N, int t) {
        return combination(t - 1, (t - 1) + (N - 1)) + combination(M - t - 1, (M - t - 1) + (N - 1));
    }

    public static void main(String[] args) {
        System.out.println((new Robot()).countPath(6, 6, 2));
    }
}
