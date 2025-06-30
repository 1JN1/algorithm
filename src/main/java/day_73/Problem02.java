package day_73;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/19
 * @description 分割等和子集
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(canPartition(new int[]{1,2,3,5}));

    }

    public boolean canPartition(int[] nums) {


        int n = nums.length;

        if (n < 2) {
            return false;
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        // 和为奇数
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        if (max > target) {
            return false;
        }

        boolean[][] dp = new boolean[n][target + 1];
        dp[0][nums[0]] = true;
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            dp[i][0] = true;
            for (int j = 1; j <= target; j++) {

                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }


        return dp[n - 1][target];
    }

}
