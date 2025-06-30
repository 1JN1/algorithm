package day_41;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/6
 * @description 位1的个数
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(hammingWeight(11));

    }

    public int hammingWeight(int n) {

        int count = 0;

        for (int i = 31; i >= 0; i--) {

            if (((n >> i) & 1) != 0) {
                count++;
            }

        }

        return count;
    }

}
