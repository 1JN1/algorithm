package day_65;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/12/3
 * @description 猜数字大小
 **/
public class Problem01 {

    @Test
    public void test() {


        System.out.println(getMoneyAmount(10));

    }


    public int getMoneyAmount(int n) {

        // dp[i][j] 表示从i-j，获胜所需的最小数字
        int[][] dp = new int[n + 1][n + 1];


        for (int i = n - 1; i >= 1; i--) {

            for (int j = i + 1; j <= n; j++) {

                dp[i][j] = j + dp[i][j - 1];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }

            }

        }

        return dp[1][n];
    }
}
