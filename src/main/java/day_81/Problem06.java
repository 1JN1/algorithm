package day_81;

/**
 * @author 王文涛
 * @date 2025/2/5
 * @description
 **/
public class Problem06 {

    public void rotate(int[][] matrix) {


        int m = matrix.length, n = matrix[0].length;

        // 按列交换
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }

        // 转置
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

}
