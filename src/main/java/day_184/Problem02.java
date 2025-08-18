package day_184;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/12 9:41
 */
public class Problem02 {

    @Test
    public void test() {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[len];
    }

}
