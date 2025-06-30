package day_128;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/4/30
 * @description
 **/
public class Problem01 {

    public int maxSum(int[] nums) {

        int[] maxDp = new int[10];
        Arrays.fill(maxDp, Integer.MIN_VALUE);
        int ans = -1;

        for (int num : nums) {

            int maxD = 0;
            for (int v = num; v > 0; v /= 10) {
                maxD = Math.max(maxD, v % 10);
            }

            ans = Math.max(ans, num + maxDp[maxD]);
            maxDp[maxD] = Math.max(maxDp[maxD], num);
        }

        return ans;
    }

}
