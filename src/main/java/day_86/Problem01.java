package day_86;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/13
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(findMin(new int[]{2,2,2,0,1}));

    }


    public int findMin(int[] nums) {

        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < right) {

            // 跳过重复元素
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }

            while (right > left && nums[right] == nums[right - 1]) {
                right--;
            }

            if (left == right) {
                break;
            }

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }


        }


        return nums[left];
    }

}
