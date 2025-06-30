package day_145;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/5/24
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] nums = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {

        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int[] sum = new int[maxNum + 1];
        for (int num : nums) {
            sum[num] += num;
        }

        int[] dp = new int[maxNum + 1];
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);

        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }

        return dp[maxNum];
    }

}
