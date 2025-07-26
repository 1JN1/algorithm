package day_175;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/25 11:17
 */
public class Problem04 {

    @Test
    public void test() {

        int[] nums1 = {70, 39, 25, 40, 7};
        int[] nums2 = {52, 20, 67, 5, 31};

        System.out.println(findLength(nums1, nums2));
    }


    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen;
    }
}
