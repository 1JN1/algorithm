package day_173;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/15 9:34
 */
public class Problem01 {

    public int countSubarrays(int[] nums) {

        int count = 0;

        int n = nums.length;
        int left = 0, right = left + 2;

        while (right < n) {

            int num = nums[left + 1];

            if ((nums[left] + nums[right]) * 2 == num) {
                count++;
            }

            left++;
            right++;
        }

        return count;
    }
}
