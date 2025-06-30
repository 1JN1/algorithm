package day_53;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/18
 * @description 二维区域和检索-矩阵不可变
 **/
public class Problem02 {

    @Test
    public void test() {

        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix1 numMatrix = new NumMatrix1(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));

    }

    class NumMatrix {

        int[][] sums;

        public NumMatrix(int[][] matrix) {

            sums = new int[matrix.length][matrix[0].length + 1];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            int sum = 0;

            for (int i = row1; i <= row2; i++) {
                sum += sums[i][col2 + 1] - sums[i][col1];
            }

            return sum;
        }
    }

    class NumMatrix1 {

        int[][] sums;

        public NumMatrix1(int[][] matrix) {


            sums = new int[matrix.length + 1][matrix[0].length + 1];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {


            return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
        }
    }

}
