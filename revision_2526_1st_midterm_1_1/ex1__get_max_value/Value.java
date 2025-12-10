package vn.io.tunaa.dsa.revision_2526_1st_midterm_1_1.ex1__get_max_value;

import java.util.Arrays;

public class Value {
    public long getMaxValue(int[] v) {
        Arrays.sort(v);

        long total = 0, minTotal = Integer.MAX_VALUE;
        int value = v[0], count = 0;

        for (int i : v) {
            total += i;

            if (i != value) {
                if ((long) value * count < minTotal) {
                    minTotal = (long) value * count;
                }

                value = i;
                count = 0;
            }

            count++;
        }

        if ((long) value * count < minTotal) {
            minTotal = (long) value * count;
        }

        return total - minTotal;
    }

    public static void main(String[] args) {
        int[] v = {6, 5, 2, 1, 2, 1, 1};
        System.out.println((new Value()).getMaxValue(v));
    }
}
