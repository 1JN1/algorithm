package day_135;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/12
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int[][] grid = {{1, 3}, {2, 2}};
        int[] ans = findMissingAndRepeatedValues(grid);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int xorAll = 0;

        // 获取1-n^2的异或结果
        for (int i = 1; i <= n * n; i++) {
            xorAll ^= i;
        }

        // 疑惑grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                xorAll ^= grid[i][j];
            }
        }

        // 求出最低位1所在的位置
        int shift = Integer.numberOfTrailingZeros(xorAll);

        int[] ans = new int[2];
        // 分组异或
        for (int i = 1; i <= n * n; i++) {
            ans[i >> shift & 1] ^= i;
        }
        for (int[] nums : grid) {
            for (int j = 0; j < n; j++) {
                ans[nums[j] >> shift & 1] ^= nums[j];
            }
        }

        for (int[] nums : grid) {
            for (int j = 0; j < n; j++) {
                if (nums[j] == ans[1]) {
                    int temp = ans[0];
                    ans[0] = ans[1];
                    ans[1] = temp;
                }
            }
        }

        return ans;
    }
}
