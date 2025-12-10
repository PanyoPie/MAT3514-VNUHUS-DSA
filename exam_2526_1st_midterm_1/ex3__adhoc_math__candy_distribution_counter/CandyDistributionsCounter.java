package vn.io.tunaa.dsa.exam_2526_1st_midterm_1.ex3__adhoc_math__candy_distribution_counter;

public class CandyDistributionsCounter {

    /**
     * Đếm số cách chia kẹo cho học sinh.
     *
     * Bài toán: Có tổng cộng c viên kẹo và s học sinh.
     * Mỗi học sinh nhận ít nhất 1 viên kẹo.
     * Yêu cầu: Đếm số cách khác nhau để chia toàn bộ c viên kẹo cho s học sinh.
     *
     * @param s tổng số học sinh cần chia kẹo
     * @param c số lượng kẹo
     * @return số cách chia kẹo.
     */
    public int countCandyDistributions(int s, int c) {
        return combination(s - 1, c - 1);
    }
    
    private int combination(int k, int n) {
        int result = 1;
        k = Math.min(n - k, k);
        
        for (int i = 1; i <= k; i++) {
            result = result * (n - k + i) / i;
        }
        
        return result;
    }
}	 	  	 		      	     		   	       	 	
