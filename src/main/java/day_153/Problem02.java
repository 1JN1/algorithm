package day_153;

/**
 * @author 王文涛
 * @date 2025/6/2
 * @description
 **/
public class Problem02 {

    public int[][] onesMinusZeros(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];

        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];

        // 一次遍历统计行和列的1的数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = 2 * (rowOnes[i] + colOnes[j]) - n - m;
            }
        }

        return ans;
    }
}
