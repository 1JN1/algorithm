package day_52;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/17
 * @description 最长递增子序列
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(lengthOfLIS2(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));
    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;

        int max = 1;

        for (int i = 1; i < n; i++) {

            int num = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    num = Math.max(num, dp[j]);
                }
            }
            dp[i] = num + 1;

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int lengthOfLIS2(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] arr = new int[n + 1];
        int maxLen = 1;
        arr[maxLen] = nums[0];

        for (int i = 1; i < n; i++) {

            if (nums[i] > arr[maxLen]) {
                arr[++maxLen] = nums[i];
            } else {

                int l = 1, r = maxLen, pos = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (arr[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                        pos = mid;
                    }
                }

                arr[pos] = nums[i];
            }

        }

        return maxLen;
    }

}
