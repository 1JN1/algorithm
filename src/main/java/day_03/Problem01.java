package day_03;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/6
 * @description 整数反转
 **/


public class Problem01 {


    @Test
    public void test() {

        System.out.println(reverse(123));


    }


    public int reverse(int x) {


        double result = 0;
        int tmp = Math.abs(x);
        int n = 0;

        // 计算数字的位数
        while (tmp != 0) {

            tmp /= 10;
            n++;

        }

        tmp = Math.abs(x);

        while (tmp != 0) {

            result = result + (tmp % 10) * Math.pow(10, n - 1);

            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }

            tmp /= 10;
            n--;
        }

        return (int) (x >= 0 ? result : -result);
    }


}
