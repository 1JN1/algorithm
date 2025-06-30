package day_42;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/7
 * @description 打家劫舍
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {2, 7, 9, 3, 1};

        System.out.println(rob(nums));

    }

    public int rob(int[] nums) {

        int dp0 = 0, dp1 = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int temp = dp0 + nums[i];

            dp0 = dp1;
            dp1 = Math.max(temp, dp1);

        }

        return dp1;
    }

}
