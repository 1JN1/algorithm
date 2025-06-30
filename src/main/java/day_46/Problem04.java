package day_46;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/11
 * @description 2的幂
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(isPowerOfTwo(-16));

    }

    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (n - 1)) == 0;
    }

}
