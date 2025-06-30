package day_41;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/6
 * @description 颠倒二进制位
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(reverseBits(-3));

    }

    public int reverseBits(int n) {


        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            ans |= (((n >> i) & 1) << (31 - i));
        }

        return ans;
    }

}
