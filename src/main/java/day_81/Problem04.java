package day_81;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/5
 * @description
 **/
public class Problem04 {

    @Test
    public void test() {

        int[] nums = {1, 1, 0, 1, 1, 1};

        System.out.println(findMaxConsecutiveOnes(nums));

    }

    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int count = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        max = Math.max(max, count);

        return max;
    }

}
