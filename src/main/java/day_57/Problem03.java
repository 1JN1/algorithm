package day_57;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/22
 * @description 4的幂
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(isPowerOfFour(8));

    }


    public boolean isPowerOfFour(int n) {

        return n > 0 && (n & (n - 1)) == 0 && (n & (0xaaaaaaaa)) == 0;
    }


}
