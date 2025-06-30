package day_85;

/**
 * @author 王文涛
 * @date 2025/2/11
 * @description
 **/
public class Problem05 {

    public int findMin(int[] nums) {

        int n = nums.length;

        int left = 0, right = n - 1;

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
