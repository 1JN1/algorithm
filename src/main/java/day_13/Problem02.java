package day_13;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/18
 * @description 搜索螺旋排序数组
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));

    }

    public int search(int[] nums, int target) {

        int n = nums.length;

        if (n == 0) {
            return -1;
        }

        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 左半部分是有序的
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {

                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }

        return -1;
    }

}
