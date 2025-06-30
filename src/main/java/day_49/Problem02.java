package day_49;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 较小的三数之和
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] nums = {3, -2, 1, 0, -1};
        System.out.println(threeSumSmaller(nums, 2));

    }

    public int threeSumSmaller(int[] nums, int target) {

        int count = 0;

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1, right = nums.length - 1;
            int num = target - nums[i];

            while (left < right) {

                if (nums[left] + nums[right] < num) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }

            }

        }

        return count;
    }

}
