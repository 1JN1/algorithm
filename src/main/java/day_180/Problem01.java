package day_180;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/1 9:35
 */
public class Problem01 {

    @Test
    public void test() {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        System.out.println(minCost(n, cuts)); // Output: 16
    }

    public int minCost(int n, int[] cuts) {

        Arrays.sort(cuts);
        int m = cuts.length + 2;
        int[] newCuts = new int[m];
        System.arraycopy(cuts, 0, newCuts, 1, m - 2);
        newCuts[m - 1] = n;

        int[][] dp = new int[m][m];

        for (int i = m - 3; i >= 0; i--) {
            for (int j = i + 2; j < m; j++) {
                int res = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    res = Math.min(res, dp[i][k] + dp[k][j]);
                }
                dp[i][j] = res + newCuts[j] - newCuts[i];
            }
        }

        return dp[0][m - 1];
    }

}
