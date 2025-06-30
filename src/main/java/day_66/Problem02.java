package day_66;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/12/5
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] nums = {1, 2, 3};
        int target = 4;

        System.out.println(combinationSum4(nums, target));

    }

    public int combinationSum4(int[] nums, int target) {


        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {

            for (int num : nums) {

                if (num <= i) {
                    dp[i] += dp[i - num];
                }

            }

        }

        return dp[target];
    }

}
