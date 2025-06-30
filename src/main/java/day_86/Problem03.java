package day_86;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/13
 * @description
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(search(new int[]{1, 3}, 3));

    }

    public boolean search(int[] nums, int target) {

        int n = nums.length;

        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return nums[0] == target;
        }

        int left = 0, right = n - 1;

        while (left < right) {

            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }

            while (left < right && nums[right] == nums[right - 1]) {
                right--;
            }

            if (left == right) {
                return nums[left] == target;
            }

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] >= nums[0]) {

                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {

                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }

        return nums[left] == target;
    }

}
