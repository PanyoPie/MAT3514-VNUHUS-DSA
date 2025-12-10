package vn.io.tunaa.dsa.week2.sorting.ex7;

import java.util.Scanner;

public class sapxeptrongxau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int[] count = new int[10];

        for (char character : s.toCharArray()) {
            count[character - '0']++;
        }

        StringBuilder result = new StringBuilder();
        for (int digit = 0; digit <= 9; digit++) {
            for (int i = 0; i < count[digit]; i++) {
                result.append(digit);
            }
        }

        System.out.println(result);
    }
}