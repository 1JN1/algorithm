package day_24;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/10
 * @description 不同路径
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(uniquePaths(3, 7));

    }


    public int uniquePaths(int m, int n) {


        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

}
