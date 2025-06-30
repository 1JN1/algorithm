package day_48;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description 搜索二维矩阵II
 **/
public class Problem01 {

    @Test
    public void test() {

        int[][] matrix = {
                {1, 1}
        };

        System.out.println(searchMatrix2(matrix, 2));

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        // 折半查找确定列范围
        int rows = matrix.length, cols = matrix[0].length, endCol = 0, endRow = 0;

        int left = 0, right = cols - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (matrix[0][mid] == target) {
                return true;
            } else if (matrix[0][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        endCol = right;

        // 折半查找确定行范围
        left = 0;
        right = rows - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        endRow = right;

        for (int i = 0; i <= endRow; i++) {

            left = 0;
            right = endCol;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {

        int x = 0, y = matrix[0].length - 1;

        while (x < matrix.length && y >= 0) {

            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y = y - 1;
            } else {
                x = x + 1;
            }

        }

        return false;
    }

}
