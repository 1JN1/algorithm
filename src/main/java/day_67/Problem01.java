package day_67;

import org.junit.Test;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author 王文涛
 * @date 2024/12/6
 * @description
 **/
public class Problem01 {


    @Test
    public void test() {


    }

    public int kthSmallest(int[][] matrix, int k) {


        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now != null && now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }

        return Objects.requireNonNull(pq.poll())[0];

    }

    public int kthSmallest2(int[][] matrix, int k) {


        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {

        // 从左下角开始移动
        int i = n - 1;
        int j = 0;
        int count = 0;

        while (i >= 0 && j < n) {

            if (matrix[i][j] <= k) {

                count += i + 1;
                j++;

            } else {
                i--;
            }

        }

        return count >= n;
    }
}
