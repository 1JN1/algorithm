package day_19;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/10/3
 * @description 旋转图像
 **/
public class Problem01 {

    @Test
    public void test() {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));

    }

    public void rotate(int[][] matrix) {

        // 转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 按列交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;


            }
        }

    }

}
