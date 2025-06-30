package day_125;

/**
 * @author 王文涛
 * @date 2025/4/26
 * @description
 **/
public class Problem02 {

    public int subarraySum(int[] nums) {

        int n = nums.length;

        // 前缀和数组
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = 0;

        for (int i = 0; i < n; i++) {

            int start = Math.max(0, i - nums[i]);

            res += preSum[i + 1] - preSum[start];

        }

        return res;
    }

}
