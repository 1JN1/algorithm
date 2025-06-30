package day_35;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/25
 * @description 只出现一次的数字
 **/
public class Problem03 {

    @Test
    public void test() {

    }

    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

}
