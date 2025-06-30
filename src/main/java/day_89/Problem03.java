package day_89;

/**
 * @author 王文涛
 * @date 2025/2/17
 * @description
 **/
public class Problem03 {

    public int splitArray(int[] nums, int k) {

        int left = 0, right = 0;
        for (int num : nums) {

            right += num;
            if (left < num) {
                left = num;
            }

        }

        while (left < right) {

            int mid = left + (right - left) / 2;
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }


        return left;
    }

    public boolean check(int[] nums, int num, int k) {

        int count = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (sum + nums[i] > num) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }

        }

        return count <= k;
    }

}
