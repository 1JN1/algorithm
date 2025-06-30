package day_81;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/5
 * @description
 **/
public class Problem05 {


    @Test
    public void test() {

        int[][] mat = {
                {2, 5, 8},
                {4, 0, -1},
        };

        System.out.println(Arrays.toString(findDiagonalOrder(mat)));

    }

    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length, n = mat[0].length;

        int[] res = new int[m * n];

        // 右上方向
        boolean flag = true;

        // 初始坐标
        int i = 0, j = 0;

        for (int k = 0; k < m * n; k++) {

            res[k] = mat[i][j];

            // 右上
            if (flag) {

                if (i == 0 && j != n - 1) {
                    j++;
                    flag = false;
                } else if (j == n - 1) {
                    i++;
                    flag = false;
                } else {
                    j++;
                    i--;
                }

                // 左下
            } else {

                if (j == 0 && i != m - 1) {
                    i++;
                    flag = true;
                } else if (i == m - 1) {
                    j++;
                    flag = true;
                } else {
                    i++;
                    j--;
                }

            }

        }

        return res;
    }
}
