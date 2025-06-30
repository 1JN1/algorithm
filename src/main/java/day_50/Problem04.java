package day_50;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description 完全平方数
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(numSquares(12));

    }

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {

                minn = Math.min(minn, dp[i - j * j]);

            }

            dp[i] = minn + 1;
        }

        return dp[n];
    }
}
