package day_36;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/26
 * @description 只出现一次的数字II
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {1, 3, 3, 1, 99, 1, 3};

        System.out.println(singleNumber2(nums));

    }

    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {

            int total = 0;

            for (int num : nums) {

                total += ((num >> i) & 1);

            }

            if (total % 3 != 0) {
                ans |= (1 << i);
            }

        }

        return ans;
    }

    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

}
