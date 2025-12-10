package vn.io.tunaa.dsa.week9.heap_and_priority_queue.ex4__frequency_sorter;

import java.util.PriorityQueue;

public class FrequencySorter {

    /**
     * Sắp xếp các ký tự chuỗi theo thứ tự tăng dần dựa trên tần suất xuất hiện.
     * Nếu hai ký tự có cùng tần suất thì sắp xếp theo thứ tự a-z.
     * @param s chuỗi ban đầu
     * @return chuỗi được sắp xếp
     */
    public static String frequencySort(String s) {
        int[] charCount = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            int countA = charCount[a - 'a'];
            int countB = charCount[b - 'a'];

            if (countA == countB) {
                return Character.compare(a, b);
            } else {
                return Integer.compare(countA, countB);
            }
        });

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        return sb.toString();
    }	 	  	 		      	     		   	       	 	
}