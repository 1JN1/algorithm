package day_149;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/5/28
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        System.out.println(deleteGreatestValue2(grid));
    }

    public int deleteGreatestValue(int[][] grid) {

        int ans = 0;

        Set<String> set = new HashSet<>();

        int m = grid.length, n = grid[0].length;

        for (int k = 0; k < n; k++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                // 找出每一行的最大值的索引
                int maxJ = -1;
                int temp = Integer.MIN_VALUE;
                for (int j = 0; j < n; j++) {

                    String key = i + " " + j;
                    if (set.contains(key)) {
                        continue;
                    }

                    if (grid[i][j] > temp) {
                        maxJ = j;
                        temp = grid[i][j];
                    }
                }

                max = Math.max(max, temp);
                set.add(i + " " + maxJ);
            }
            ans += max;
        }


        return ans;
    }

    public int deleteGreatestValue2(int[][] grid) {
        int ans = 0;

        int m = grid.length, n = grid[0].length;

        for (int[] row : grid) {
            Arrays.sort(row);
        }

        // 遍历每一列
        for (int i = 0; i < n; i++) {

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }

            ans += max;
        }
        return ans;
    }
}
