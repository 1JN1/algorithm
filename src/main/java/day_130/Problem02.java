package day_130;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/5
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        char[][] grid = new char[][]{
                {'X', 'Y', '.'},
                {'Y', '.', '.'},
        };

        System.out.println(numberOfSubmatrices2(grid));

    }

    public int numberOfSubmatrices(char[][] grid) {

        int count = 0;

        int m = grid.length, n = grid[0].length;

        // 遍历所有子矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (judge(grid, i, j)) {
                    count++;
                }

            }
        }

        return count;
    }

    public boolean judge(char[][] grid, int row, int col) {

        // 统计X和Y出现的次数
        int x = 0, y = 0;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (grid[i][j] == 'X') {
                    x++;
                } else if (grid[i][j] == 'Y') {
                    y++;
                }
            }
        }


        return x != 0 && x == y;
    }

    public int numberOfSubmatrices2(char[][] grid) {

        int ans = 0;
        int m = grid.length, n = grid[0].length;

        int[][][] count = new int[m + 1][n + 1][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                count[i + 1][j + 1][0] = count[i + 1][j][0] + count[i][j + 1][0] - count[i][j][0];
                count[i + 1][j + 1][1] = count[i + 1][j][1] + count[i][j + 1][1] - count[i][j][1];

                if (grid[i][j] == 'X') {
                    count[i + 1][j + 1][0]++;
                } else if (grid[i][j] == 'Y') {
                    count[i + 1][j + 1][1]++;
                }

                if (count[i + 1][j + 1][0] != 0 && count[i + 1][j + 1][0] == count[i + 1][j + 1][1]) {
                    ans += 1;
                }

            }
        }


        return ans;
    }
}
