package day_53;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/18
 * @description 区域和检索-数组不可变
 **/
public class Problem01 {

    @Test
    public void test() {

    }

    class NumArray {

        int[] sums;

        public NumArray(int[] nums) {

            sums = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }

        }

        public int sumRange(int left, int right) {

            return sums[right + 1] - sums[left];
        }
    }

}
