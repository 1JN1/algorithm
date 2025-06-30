package day_107;

import org.junit.Test;

import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/3/14
 * @description
 **/
public class Problem01 {


    @Test
    public void test() {
        int[][] grid = {{23, 17, 15, 3, 20}, {8, 1, 20, 27, 11}, {9, 4, 6, 2, 21}, {40, 9, 1, 10, 6}, {22, 7, 4, 5, 3}};
        System.out.println(maxTrailingZeros(grid));
    }

    static int[][] c25 = new int[1001][2];

    static {
        // 预处理：递推算出每个数的因子 2 的个数和因子 5 的个数
        for (var i = 2; i <= 1000; i++) {
            if (i % 2 == 0) {
                c25[i][0] = c25[i / 2][0] + 1;
            }
            if (i % 5 == 0) {
                c25[i][1] = c25[i / 5][1] + 1;
            }
        }
    }

    public int maxTrailingZeros(int[][] grid) {

        int m = grid.length, n = grid[0].length, ans = 0;

        int[][][] s25 = new int[m][n + 1][2];

        // 计算每一行的前缀和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 前一个数的2的前缀和加上前一个数的因子2的数目
                s25[i][j + 1][0] = s25[i][j][0] + c25[grid[i][j]][0];
                s25[i][j + 1][1] = s25[i][j][1] + c25[grid[i][j]][1];
            }
        }

        for (int j = 0; j < n; j++) {

            // 当前路径因子2的数目和因子5的数目
            int s2 = 0, s5 = 0;
            // 从上往下
            for (int i = 0; i < m; i++) {

                s2 += c25[grid[i][j]][0];
                s5 += c25[grid[i][j]][1];

                ans = Math.max(
                        ans,
                        Math.max(
                                // 左拐
                                Math.min(s2 + s25[i][j][0], s5 + s25[i][j][1]),
                                // 右拐
                                Math.min(s2 + s25[i][n][0] - s25[i][j + 1][0], s5 + s25[i][n][1] - s25[i][j + 1][1])
                        )
                );

            }

            // 从下往上
            s2 = 0;
            s5 = 0;
            for (int i = m - 1; i >= 0; i--) {

                s2 += c25[grid[i][j]][0];
                s5 += c25[grid[i][j]][1];

                ans = Math.max(
                        ans,
                        Math.max(
                                // 左拐
                                Math.min(s2 + s25[i][j][0], s5 + s25[i][j][1]),
                                // 右拐
                                Math.min(s2 + s25[i][n][0] - s25[i][j + 1][0], s5 + s25[i][n][1] - s25[i][j + 1][1])
                        )
                );

            }

        }

        return ans;
    }
}
