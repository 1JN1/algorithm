package day_40;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/5
 * @description 阶乘后的0
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(trailingZeroes(10));

    }

    public int trailingZeroes(int n) {

        int count = 0;

        while (n != 0) {

            n /= 5;
            count += n;

        }

        return count;
    }

}
