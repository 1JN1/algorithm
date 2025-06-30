package day_44;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/9
 * @description 打家劫舍II
 **/
public class Problem04 {

    @Test
    public void test() {

        int[] nums = {1, 1, 1, 2};

        System.out.println(rob(nums));

    }

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }


        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int start, int end) {

        int dp0 = nums[start], dp1 = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {

            int temp = dp0;
            dp0 = dp1;

            dp1 = Math.max(temp + nums[i], dp0);

        }

        return dp1;
    }

}
