package day_88;

/**
 * @author 王文涛
 * @date 2025/2/15
 * @description
 **/
public class Problem04 {

    public boolean isPerfectSquare(int num) {

        int left = 1, right = num;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long square = (long) mid * (long) mid;

            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return false;
    }

}
