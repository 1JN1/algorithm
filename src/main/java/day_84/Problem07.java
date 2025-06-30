package day_84;

import java.util.Random;

/**
 * @author 王文涛
 * @date 2025/2/10
 * @description
 **/
public class Problem07 {

    class Solution {

        int[] nums;
        int[] origin;
        Random random;

        public Solution(int[] nums) {

            this.nums = nums;
            this.origin = new int[nums.length];
            System.arraycopy(nums, 0, origin, 0, nums.length);
            this.random = new Random();

        }

        public int[] reset() {
            System.arraycopy(origin, 0, nums, 0, origin.length);
            return nums;
        }

        public int[] shuffle() {

            for (int i = 0; i < nums.length; i++) {

                int j = i + random.nextInt(nums.length - i);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }

            return nums;
        }
    }

}
