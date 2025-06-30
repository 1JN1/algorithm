package day_25;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/11
 * @description 搜索二维矩阵
 **/
public class Problem04 {

    @Test
    public void test() {

        int[][] matrix = {
                {1}
        };

        System.out.println(searchMatrix2(matrix, 0));

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        // 折半查找第一列，找到目标行
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m - 1;

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

        if (right < 0) {
            return false;
        }

        // 目标行
        int row = right;
        left = 0;
        right = n - 1;

        // 折半查找行
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return false;
    }

}
