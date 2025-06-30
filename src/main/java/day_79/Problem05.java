package day_79;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/1
 * @description
 **/
public class Problem05 {

    @Test
    public void test() {

        int[][] grid = {
                {1, 0}
        };

        System.out.println(islandPerimeter(grid));

    }

    public int islandPerimeter(int[][] grid) {

        int count = 0;

        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 陆地
                if (grid[i][j] == 1) {

                    int num = 4;

                    // 上
                    if (j != 0 && grid[i][j - 1] == 1) {
                        num--;
                    }

                    // 下
                    if (j != n - 1 && grid[i][j + 1] == 1) {
                        num--;
                    }

                    // 左
                    if (i != 0 && grid[i - 1][j] == 1) {
                        num--;
                    }

                    // 右
                    if (i != m - 1 && grid[i + 1][j] == 1) {
                        num--;
                    }

                    count += num;
                }
            }
        }

        return count;
    }

}
