package day_39;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/4
 * @description 寻找峰值
 **/
public class Problem03 {

    @Test
    public void test() {

        int[] nums = {1, 2};

        System.out.println(findPeakElement(nums));

    }

    public int findPeakElement(int[] nums) {


        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // 判断两端
            if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (mid == 0) {
                left = mid + 1;
            } else if (mid == nums.length - 1) {
                right = mid - 1;
            } else {
                if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                    return mid;
                } else if (nums[mid] >= nums[mid - 1] && nums[mid] <= nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

}
