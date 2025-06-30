package day_86;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/13
 * @description
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(findPeakElement(new int[]{1, 2}));

    }

    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int left = 0, right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                }
            } else if (mid == n - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                }
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

}
