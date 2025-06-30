package day_136;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 王文涛
 * @date 2025/5/13
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[][] grid = {{5, 3, 7}, {8, 2, 6}};
        int[] limits = {2, 2};
        int k = 3;

        System.out.println(maxSum(grid, limits, k));
    }

    public long maxSum(int[][] grid, int[] limits, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = grid.length;

        for (int i = 0; i < n; i++) {
            int count = limits[i];
            Arrays.sort(grid[i]);
            int m = grid[i].length;
            // 从后往前取 `count` 个最大的元素
            for (int j = m - 1; j >= 0 && count > 0; j--, count--) {
                int num = grid[i][j];
                if (pq.size() < k) {
                    pq.offer(num);
                } else if (!pq.isEmpty() && num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                } else {
                    break; // 后面的更小，无需继续
                }
            }
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}
