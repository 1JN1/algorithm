package day_178;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/29 10:38
 */
public class Problem04 {

    @Test
    public void test() {

        int[] nums = {1, 2, 3, 4, 5, 6};

        System.out.println(triangularSum(nums));

    }


    public int triangularSum(int[] nums) {
        int len = nums.length;

        // 原地操作，从后往前处理避免覆盖问题
        for (int size = len; size > 1; size--) {
            for (int i = 0; i < size - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }

        return nums[0];
    }
}
