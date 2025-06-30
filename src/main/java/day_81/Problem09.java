package day_81;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/5
 * @description
 **/
public class Problem09 {

    @Test
    public void test() {

        System.out.println(Arrays.deepToString(generateMatrix(3)));

    }

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        int count = 1;

        while (count <= n * n) {

            // 右
            for (int i = left; i <= right && count <= n * n; i++) {
                matrix[top][i] = count;
                count++;
            }

            top++;

            // 下
            for (int i = top; i <= bottom && count <= n * n; i++) {
                matrix[i][right] = count;
                count++;
            }
            right--;

            // 左
            for (int i = right; i >= left && count <= n * n; i--) {
                matrix[bottom][i] = count;
                count++;
            }

            bottom--;

            // 上
            for (int i = bottom; i >= top && count <= n * n; i--) {
                matrix[i][left] = count;
                count++;
            }

            left++;

        }

        return matrix;
    }
}
