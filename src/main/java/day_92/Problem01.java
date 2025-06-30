package day_92;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/21
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {-5, -3, -2, -1};

        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        int k = n - 1;

        int left = 0, right = n - 1;

        while (left <= right) {

            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[k--] = nums[left] * nums[left];
                left++;
            } else {
                res[k--] = nums[right] * nums[right];
                right--;
            }

        }


        return res;
    }

}
