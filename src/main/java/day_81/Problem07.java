package day_81;

/**
 * @author 王文涛
 * @date 2025/2/5
 * @description
 **/
public class Problem07 {
    public void setZeroes(int[][] matrix) {


        int m = matrix.length, n = matrix[0].length;

        boolean rowZero = false, colZero = false;

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (colZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
