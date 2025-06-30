package day_156;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/9
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[][] grid = {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };

        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int[] rowMax = new int[m];
        int[] colMax = new int[n];

        // 求出每一行每一列的最大值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == rowMax[i] || grid[i][j] == colMax[j]) {
                    continue;
                }
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }

        return ans;
    }

}
