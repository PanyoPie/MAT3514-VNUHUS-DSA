package vn.io.tunaa.dsa.week9.heap_and_priority_queue.ex5__min_cost_to_activate_servers;

import java.util.*;

public class MinCostToActivateServers {
    /**
     * Tính toán chi phí tối thiểu để kích hoạt đúng k máy chủ.
     *
     * @param performance mảng hiệu năng của từng máy chủ
     * @param baseCost mảng chi phí cơ bản tương ứng
     * @param k số lượng máy chủ cần thuê
     * @return chi phí nhỏ nhất có thể để kích hoạt k máy chủ
     */
    public static double minCostToActivate(int[] performance, int[] baseCost, int k) {
        int n = performance.length;
        double[][] servers = new double[n][2];

        for (int i = 0; i < n; i++) {
            servers[i] = new double[] {
                    (double) baseCost[i] / performance[i],
                    performance[i]
            };
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(servers, Comparator.comparingDouble(a -> a[0]));

        double minCost = Double.MAX_VALUE;
        int total = 0;

        for (double[] server : servers) {
            int serverPerformance = (int) server[1];
            pq.offer(serverPerformance);

            total += serverPerformance;

            if (pq.size() > k && k > 0) {
                total -= pq.poll();
            }	 	  	 		      	     		   	       	 	

            if (pq.size() == k) {
                double cost = server[0] * total;
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(minCostToActivate(new int[] {10, 20, 5}, new int[] {70, 50, 30}, 2));
    }
}