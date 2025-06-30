package day_45;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/10
 * @description 最大长方形
 **/
public class Problem03 {


    @Test
    public void test() {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };

        System.out.println(maximalSquare2(matrix));

    }


    public int maximalSquare(char[][] matrix) {

        int m = matrix.length, n = matrix[0].length, maxLen = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {

                    maxLen = maxLen == 0 ? 1 : maxLen;

                    while (maximalSquareHelper(matrix, i, j, maxLen + 1)) {
                        maxLen++;
                    }
                }
            }
        }

        return maxLen * maxLen;
    }

    public boolean maximalSquareHelper(char[][] matrix, int row, int col, int len) {

        int m = matrix.length, n = matrix[0].length;

        for (int i = row; i < row + len; i++) {

            for (int j = col; j < col + len; j++) {

                if (i >= m || j >= n || matrix[i][j] != '1') {
                    return false;
                }

            }

        }

        return true;
    }

    public int maximalSquare2(char[][] matrix) {


        int m = matrix.length, n = matrix[0].length, maxLen = 0;

        int[] left = new int[m], up = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1') {

                    if (i == 0 || j == 0) {
                        left[i] = 1;
                        up[j] = 1;
                    } else {
                        left[i] = Math.min(left[i], Math.min(left[i - 1], up[j])) + 1;
                    }

                } else {
                    left[i] = 0;
                    up[j] = 0;
                }

                maxLen = Math.max(maxLen, left[i]);

            }
        }

        return maxLen * maxLen;
    }

    public int maximalSquare3(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        int[] dp = new int[width + 1];

        for (char[] chars : matrix) {
            int northwest = 0;
            for (int col = 0; col < width; col++) {
                int nextNorthwest = dp[col + 1];
                if (chars[col] == '1') {
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else dp[col + 1] = 0;
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }
}
