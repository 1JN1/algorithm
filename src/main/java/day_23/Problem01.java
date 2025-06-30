package day_23;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/10/8
 * @description 螺旋矩阵II
 **/
public class Problem01 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int num = 1;

        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (num <= n * n) {

            // 从左到右
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num;
                num++;
            }

            top++;

            // 从上到下
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num;
                num++;
            }

            right--;

            // 从右到左
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num;
                num++;
            }

            bottom--;

            // 从下到上
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num;
                num++;
            }

            left++;

        }

        return matrix;
    }

}
