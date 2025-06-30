package day_91;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/20
 * @description
 **/
public class Problem08 {

    @Test
    public void test() {

        int[] nums = {1, 0, 2};

        sortColors(nums);

        System.out.println(Arrays.toString(nums));

    }

    public void sortColors(int[] nums) {

        int n = nums.length;
        int left = 0, right = n - 1, i = 0;

        while (i <= right) {

            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                i++;
            }

        }

    }

}
