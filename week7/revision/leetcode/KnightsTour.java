package vn.io.tunaa.dsa.week7.revision.leetcode;

import java.util.*;

public class KnightsTour {
    private final static int[] knightMoveX = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private final static int[] knightMoveY = { 1, 2, 2, 1, -1, -2, -2, -1 };

    private static int[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();

        int[][] board = knightTour(n, startX, startY);
        printBoard(board);
    }

    private static boolean isValid(int x, int y, int n) {
        return (x < n && y < n) && (x >= 0 && y >= 0) && board[x][y] == -1;
    }

    private static PriorityQueue<int[]> getPriorityQueue(int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < 8; i++) {
            int nx = x + knightMoveX[i];
            int ny = y + knightMoveY[i];

            if (isValid(nx, ny, board.length)) {
                pq.add(new int[] { nx, ny, countOnwardMoves(nx, ny) });
            }
        }

        return pq;
    }

    private static int countOnwardMoves(int x, int y) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + knightMoveX[i];
            int ny = y + knightMoveY[i];

            if (isValid(nx, ny, board.length)) {
                count++;
            }
        }

        return count;
    }

    private static int[][] knightTour(int n, int startX, int startY) {
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = -1;
            }
        }
        board[startX][startY] = 1;

        touring(n, startX, startY, 2);
        return board;
    }

    private static boolean touring(int n, int x, int y, int countMoves) {
        if (countMoves == n * n + 1) {
            return true;
        }

        PriorityQueue<int[]> tmp = getPriorityQueue(x, y);

        while (!tmp.isEmpty()) {
            int[] tmpMove = tmp.poll();
            int nx = tmpMove[0];
            int ny = tmpMove[1];

            board[nx][ny] = countMoves;
            if (touring(n, nx, ny, countMoves + 1)) {
                return true;
            }
            board[nx][ny] = -1;
        }

        return false;
    }

    private static void printBoard(int[][] board) {
        for (int[] i : board) {
            for (int j : i) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}