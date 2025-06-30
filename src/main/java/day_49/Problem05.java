package day_49;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 丑数II
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(nthUglyNumber2(10));

    }

    public int nthUglyNumber(int n) {

        int[] factors = {2, 3, 5};

        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();

        set.add(1L);
        heap.add(1L);

        int ugly = 0;

        for (int i = 0; i < n; i++) {

            long curr = heap.poll();

            ugly = (int) curr;

            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }

            }

        }

        return ugly;
    }

    public int nthUglyNumber2(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;

        for (int i = 2; i <= n; i++) {

            int num1 = dp[p2] * 2, num2 = dp[p3] * 3, num3 = dp[p5] * 5;

            dp[i] = Math.min(num1, Math.min(num2, num3));

            if (dp[i] == num1) {
                p2++;
            }

            if (dp[i] == num2) {
                p3++;
            }

            if (dp[i] == num3) {
                p5++;
            }

        }

        return dp[n];
    }

}
