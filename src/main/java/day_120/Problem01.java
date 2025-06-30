package day_120;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/4/14
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {8, 6, 3, 13, 2, 12, 19, 5, 19, 6, 10, 11, 9};

        System.out.println(maximumTripletValue2(nums));
    }

    public long maximumTripletValue(int[] nums) {

        long ans = 0;

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    long cur = (long) (nums[i] - nums[j]) * nums[k];
                    ans = Math.max(ans, cur);
                }
            }
        }

        return ans;
    }

    /**
     * 贪心优化
     *
     * @param nums
     * @return
     */
    public long maximumTripletValue2(int[] nums) {

        long ans = 0;

        int len = nums.length;

        for (int k = 2; k < len; k++) {

            int m = nums[0];
            for (int j = 1; j < k; j++) {
                long cur = (long) (m - nums[j]) * nums[k];
                ans = Math.max(ans, cur);
                m = Math.max(m, nums[j]);
            }

        }

        return ans;
    }

    /**
     * 使用贪心加前后缀数组优化
     */
    public long maximumTripletValue3(int[] nums) {

        long ans = 0;
        int len = nums.length;

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[len - i - 1] = Math.max(rightMax[len - i], nums[len - i]);
        }

        for (int j = 1; j < len - 1; j++) {
            long cur = (long) (leftMax[j] - nums[j]) * rightMax[j];
            ans = Math.max(ans, cur);
        }

        return ans;
    }

    public long maximumTripletValue4(int[] nums) {

        long ans = 0;
        int len = nums.length;

        long iMax = 0, dMax = 0;

        for (int k = 0; k < len; k++) {
            ans = Math.max(ans, dMax * nums[k]);
            dMax = Math.max(dMax, iMax - nums[k]);
            iMax = Math.max(iMax, nums[k]);
        }

        return ans;
    }

}
