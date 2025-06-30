package day_56;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/21
 * @description 3的幂
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(isPowerOfThree(6));

    }

    public boolean isPowerOfThree(int n) {

        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThree2(int n) {

        int num = 1;

        while (num < n) {
            num *= 3;
        }

        return num == n;
    }

}
