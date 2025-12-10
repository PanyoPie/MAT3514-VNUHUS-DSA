package vn.io.tunaa.dsa.revision_2526_1st_midterm_1_2.ex1__get_min_value;

import java.util.Arrays;

public class Value {
    public long getMinValue(int[] v) {
        Arrays.sort(v);

        long total = 0, maxTotal = Integer.MIN_VALUE;
        int value = v[0], count = 0;

        for (int i : v) {
            total += i;

            if (i != value) {
                if ((long) value * count > maxTotal) {
                    maxTotal = (long) value * count;
                }

                value = i;
                count = 0;
            }

            count++;
        }

        if ((long) value * count > maxTotal) {
            maxTotal = (long) value * count;
        }

        return total - maxTotal;
    }

    public static void main(String[] args) {
        int[] v = {6, 5, 2, 1, 2, 1, 1};
        System.out.println((new Value()).getMinValue(v));
    }
}
