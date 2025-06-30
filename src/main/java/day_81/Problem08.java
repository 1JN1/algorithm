package day_81;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/2/5
 * @description
 **/
public class Problem08 {

    public List<Integer> spiralOrder(int[][] matrix) {


        List<Integer> list = new ArrayList<>();

        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = n - 1, up = 0, down = m - 1;
        int count = 0;

        while (count < m * n) {

            // 右
            for (int i = left; i <= right && count < m * n; i++) {
                list.add(matrix[up][i]);
                count++;
            }

            up++;

            // 下
            for (int i = up; i <= down && count < m * n; i++) {
                list.add(matrix[i][right]);
                count++;
            }

            right--;

            // 左
            for (int i = right; i >= left && count < m * n; i--) {
                list.add(matrix[down][i]);
                count++;
            }

            down--;

            // 上
            for (int i = down; i >= up && count < m * n; i--) {
                list.add(matrix[i][left]);
                count++;
            }

            left++;

        }

        return list;
    }

}
