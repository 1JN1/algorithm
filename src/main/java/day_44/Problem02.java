package day_44;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/9
 * @description 长度最小的子数组
 **/
public class Problem02 {

    @Test
    public void test() {

        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(minSubArrayLen(target, nums));

    }

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0, right = 0, sum = 0, minLen = 0, n = nums.length;

        while (right < n) {

            sum += nums[right];
            while (left <= right && sum >= target) {

                minLen = minLen == 0 ? (right - left + 1) : Math.min(minLen, right - left + 1);
                sum -= nums[left++];

            }
            right++;

        }

        return minLen;
    }

}
