package day_38;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/2
 * @description 寻找旋转排序数组中的最小值
 **/
public class Problem04 {

    @Test
    public void test() {

        int[] nums = {2, 1};

        System.out.println(findMin(nums));

    }

    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == 0 && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            }

            if (mid == nums.length - 1 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (mid > 0 && mid < nums.length && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return 0;
    }

    public int findMin2(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return nums[left];
    }

}
