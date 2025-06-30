package day_20;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/4
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(myPow(2, Integer.MIN_VALUE));

    }


    public double myPow(double x, int n) {


        long temp = n;
        double num = x;
        double result = 1;

        if (n < 0) {
            temp = -temp;
        }

        // 快速幂
        while (temp > 0) {

            if (temp % 2 == 1) {
                result *= num;
            }

            num *= num;
            temp /= 2;

        }

        return n >= 0 ? result : (1.0 / result);
    }

}
