package day_27;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/13
 * @description 搜索旋转排序数组 II
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {1, 0, 1, 1, 1};

        System.out.println(search(nums, 0));

    }


    public boolean search(int[] nums, int target) {

        int n = nums.length;

        int l = 0, r = n - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // 无法判断区间是否有序
            if (nums[l] == nums[mid] && nums[r] == nums[mid]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {

                if (nums[l] <= target && nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }


        return false;
    }

}
