package day_91;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/20
 * @description
 **/
public class Problem06 {

    @Test
    public void test() {

        int[] nums = {2, 3, 8, 9, 10};
        int target = 16;

        System.out.println(threeSumClosest(nums, target));

    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }

                if (Math.abs(best - target) > Math.abs(sum - target)) {
                    best = sum;
                }
            }

        }


        return best;
    }

}
