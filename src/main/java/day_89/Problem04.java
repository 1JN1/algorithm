package day_89;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/17
 * @description
 **/
public class Problem04 {

    @Test
    public void test() {

        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(11, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {

        int left = 1, right = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;
            if (check(nums, target, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return check(nums, target, left) ? left : 0;
    }

    public boolean check(int[] nums, int target, int len) {

        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i >= len) {
                sum -= nums[left++];
            }

            sum += nums[i];
            if (sum >= target) {
                return true;
            }

        }

        return false;
    }

    public int minSubArrayLen2(int target, int[] nums) {

        int start = 0, end = 0, n = nums.length, sum = 0;
        int ans = Integer.MAX_VALUE;


        while (end < n) {

            sum += nums[end];
            while (sum >= target) {

                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];

            }

            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
