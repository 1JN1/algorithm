package day_21;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/5
 * @description 螺旋矩阵
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));

    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        List<Integer> ans = new ArrayList<>(m * n);

        // 上下左右边界
        int up = 0, down = m - 1, left = 0, right = n - 1;

        // 已经输出的元素个数
        int count = 0;

        while (true) {

            // 从左到右
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
                count++;
            }

            if (count == m * n) {
                break;
            }

            up++;

            // 从上到下
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
                count++;
            }

            if (count == m * n) {
                break;
            }

            right--;

            // 从右到左
            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
                count++;
            }

            if (count == m * n) {
                break;
            }

            down--;

            // 从下到上
            for (int i = down; i >= up; i--) {
                ans.add(matrix[i][left]);
                count++;
            }

            if (count == m * n) {
                break;
            }

            left++;
        }


        return ans;
    }

}
