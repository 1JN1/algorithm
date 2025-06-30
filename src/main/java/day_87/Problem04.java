package day_87;

/**
 * @author 王文涛
 * @date 2025/2/14
 * @description
 **/
public class Problem04 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;

        while (x < m && y >= 0) {

            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y -= 1;
            } else {
                x += 1;
            }

        }

        return false;
    }
}
