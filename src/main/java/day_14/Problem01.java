package day_14;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/26
 * @description 在排序数组中查找元素的第一个和最后一个位置
 **/
public class Problem01 {


    @Test
    public void test() {

    }

    public int[] searchRange(int[] nums, int target) {

        // 左边界
        int left = binarySearch(nums, target, true);

        // 右边界
        int right = binarySearch(nums, target, false);

        if (left <= right - 1 && right - 1 < nums.length && nums[left] == target && nums[right - 1] == target) {
            return new int[]{left, right - 1};
        }

        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean flag) {

        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > target || flag && nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return ans;
    }

}
