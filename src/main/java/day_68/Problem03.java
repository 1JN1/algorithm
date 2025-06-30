package day_68;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author 王文涛
 * @date 2024/12/7
 * @description
 **/
public class Problem03 {

    @Test
    public void test() {


        Solution solution = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));

    }

    class Solution {

        int[] nums;
        Random rand;
        int[] original;

        public Solution(int[] nums) {
            this.nums = nums;
            rand = new Random();
            this.original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
        }

        public int[] reset() {

            System.arraycopy(original, 0, nums, 0, nums.length);
            return nums;
        }

        public int[] shuffle() {

            int size = nums.length;

            for (int i = size; i > 1; i--) {
                swap(nums, i - 1, rand.nextInt(i));
            }

            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
