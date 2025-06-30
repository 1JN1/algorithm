package day_25;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/11
 * @description x的平方根
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(mySqrt2(2147395599));

    }


    public int mySqrt(int x) {


        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0, right = x;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return left - 1;
    }

    /**
     * 牛顿迭代法求算术平方根，求y = x^2 - c的零点
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        double c = x, x0 = x;

        while (true) {

            double xi = 0.5 * (x0 + c / x0);

            // 几乎没有前进
            if (Math.abs(xi - x0) < 1e-7) {
                return (int) xi;
            }

            x0 = xi;
        }

    }


}
