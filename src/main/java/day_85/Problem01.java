package day_85;

/**
 * @author 王文涛
 * @date 2025/2/11
 * @description
 **/
public class Problem01 {

    public int search(int[] nums, int target) {

        int n = nums.length;

        int left = 0, right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return -1;
    }

}
