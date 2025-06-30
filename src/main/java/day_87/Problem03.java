package day_87;

/**
 * @author 王文涛
 * @date 2025/2/14
 * @description
 **/
public class Problem03 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int num = matrix[mid / n][mid % n];
            if (num == target) {
                return true;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return false;
    }

}
