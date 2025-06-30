package day_105;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/12
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int[][] grid = {
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        };
        System.out.println(maxProductPath(grid));
    }

    public int maxProductPath(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j - 1][0] * grid[0][j];
        }

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i][0][1] = dp[i - 1][0][0] * grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long leftMax = dp[i][j - 1][0];
                long leftMin = dp[i][j - 1][1];
                long upMax = dp[i - 1][j][0];
                long upMin = dp[i - 1][j][1];

                if (grid[i][j] >= 0) {
                    dp[i][j][0] = Math.max(leftMax, upMax) * grid[i][j];
                    dp[i][j][1] = Math.min(leftMin, upMin) * grid[i][j];
                } else {
                    dp[i][j][0] = Math.min(leftMin, upMin) * grid[i][j];
                    dp[i][j][1] = Math.max(leftMax, upMax) * grid[i][j];
                }

            }
        }

        if (dp[m - 1][n - 1][0] < 0) {
            return -1;
        }

        return (int)(dp[m - 1][n - 1][0] % 1000000007);
    }
}
