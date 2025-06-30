package day_13;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/18
 * @description 两数相除
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(divide(-2147483648, -1));

    }

    public int divide(int dividend, int divisor) {


        // 被除数是最小值
        if (dividend == Integer.MIN_VALUE) {

            if (divisor == 1) {
                return dividend;
            }

            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }

        }

        // 除数是最小值
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        // 被除数是0
        if (dividend == 0) {
            return 0;
        }

        boolean rev = false;

        if (dividend > 0) {

            dividend = -dividend;
            rev = !rev;

        }

        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        // 二分查找找出答案
        int left = 1, right = Integer.MAX_VALUE, ans = 0;

        while (left <= right) {

            int mid = left + ((right - left) >> 1);

            if (quickAdd(divisor, mid, dividend)) {
                ans = mid;
                // 避免溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return rev ? -ans : ans;
    }


    // 利用加法实现乘法
    public boolean quickAdd(int y, int n, int x) {

        int result = 0, add = y;

        while (n != 0) {

            if ((n & 1) != 0) {

                // 判断是否满足条件 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }

            if (n != 1) {

                if (add < x - add) {
                    return false;
                }

                add += add;
            }

            n >>= 1;

        }

        return true;
    }

}
