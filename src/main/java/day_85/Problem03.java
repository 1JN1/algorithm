package day_85;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/11
 * @description
 **/
public class Problem03 {

    @Test
    public void test() {

        int[] nums = {2, 2};

        System.out.println(Arrays.toString(searchRange(nums, 1)));

    }

    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        if (n == 0) {
            return new int[]{-1, -1};
        }

        int left = 0, right = n - 1;

        // 找第一次出现的位置
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        int first = nums[left] == target ? left : -1;

        left = 0;
        right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        int last = -1;

        if (right >= 0 && nums[right] == target) {
            last = right;
        }


        return new int[]{first, last};
    }

}
