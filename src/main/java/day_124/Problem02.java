package day_124;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/4/22
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] nums = {2, 5, 6, 8, 5};
        int k = 4;
        System.out.println(minOperationsToMakeMedianK(nums, k));
    }

    public long minOperationsToMakeMedianK(int[] nums, int k) {

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] - k;
        }

        Arrays.sort(nums);

        int mid = midNum(nums);

        long count = 0;

        count += Math.abs(mid);
        if (mid > 0) {
            for (int i = 0; i < len / 2; i++) {
                if (nums[i] > 0) {
                    count += nums[i];
                }
            }
        } else {
            for (int i = (len / 2) + 1; i < len; i++) {
                if (nums[i] < 0) {
                    count -= nums[i];
                }
            }
        }


        return count;
    }

    private int midNum(int[] nums) {

        int len = nums.length;

        return nums[len / 2];
    }

}
