package day_25;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/10/11
 * @description 矩阵置零
 **/
public class Problem03 {

    @Test
    public void test() {

        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        setZeroes2(matrix);

        System.out.println(Arrays.deepToString(matrix));

    }


    public void setZeroes(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        // 记录行列有没有零
        boolean[] row = new boolean[m], col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }

            }
        }

        // 行置零
        for (int i = 0; i < m; i++) {
            if (row[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 列置0
        for (int i = 0; i < n; i++) {
            if (col[i]) {

                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }

            }
        }

    }

    /**
     * 空间复杂度为 o(1)的方法
     *
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        // 记录第一行和第一列有没有0
        boolean rowFlag = false, colFlag = false;

        // 扫描第一行
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        // 扫描第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        // 使用矩阵的第一行和第一列记录矩阵改行或该列是否存在0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }

            }
        }

        // 存在0的行列置换为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 原来第一行存在0
        if (rowFlag) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        // 原来第一列存在0
        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
