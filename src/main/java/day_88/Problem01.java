package day_88;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/15
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(mySqrt(1));

    }

    public int mySqrt(int x) {

        if (x == 1) {
            return 1;
        }

        int left = 1, right = x;
        while (left < right) {

            int mid = left + (right - left) / 2;
            if ((long) mid * (long) mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

}
