package day_109;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/17
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(smallestRepunitDivByK(3));
    }

    public int smallestRepunitDivByK(int k) {

        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int num = 0;
        //int num1 = 0;

        for (int i = 1; i <= k; i++) {
            // num1 = (num1 * 10 + 1) % k;
            num = (num * (10 % k) + 1) % k;
            if (num == 0) {
                return i;
            }

        }

        return -1;
    }

}
