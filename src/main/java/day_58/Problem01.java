package day_58;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/25
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(integerBreak2(10));

    }

    public int integerBreak(int n) {

        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {

            int max = i * i / 4;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, j * dp[i - j]);
            }
            dp[i] = max;
        }

        return dp[n];
    }

    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {

            dp[i] = Math.max(2 * (i - 2), Math.max(2 * dp[i - 2], Math.max(3 * (i - 3), 3 * dp[i - 3])));

        }

        return dp[n];
    }

}
