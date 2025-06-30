package day_103;

/**
 * @author 王文涛
 * @date 2025/3/10
 * @description
 **/
public class Problem01 {

    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int n = nums.length;

        int i = 0;
        int ans = 0;

        while (i < n) {

            if (nums[i] > threshold) {
                i++;
                continue;
            }

            if (nums[i] % 2 != 0) {
                i++;
                continue;
            }

            int j = i + 1;
            while (j < n && nums[j] <= threshold && (nums[j] % 2 != nums[j - 1] % 2)) {
                j++;
            }

            ans = Math.max(ans, j - i);
            i = j;

        }

        return ans;
    }

}
