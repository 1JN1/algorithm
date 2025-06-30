package day_123;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/4/21
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[][] cost = {
                {2, 4, 6},
                {5, 3, 8},
                {7, 1, 9},
                {4, 6, 2},
                {3, 5, 7},
                {8, 2, 4}
        };
        System.out.println(minCost(6, cost));
    }

    public long minCost(int n, int[][] cost) {

        int[] used = new int[n];

        Arrays.fill(used, -1);

        long ans = dfs(n, 0, cost, used);

        return ans;
    }


    public long dfs(int n, int idx, int[][] cost, int[] used) {

        if (idx == n) {
            return 0;
        }

        List<Integer> exclude = new ArrayList<>();

        if (idx > 0) {
            exclude.add(used[idx - 1]);
        }

        if (idx >= (n / 2) && (n - idx) >= 1) {
            exclude.add(used[n - idx - 1]);
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            if (!exclude.contains(i)) {
                used[idx] = i;
                ans = Math.min(ans, dfs(n, idx + 1, cost, used) + cost[idx][i]);
            }
        }

        return ans;
    }

    public long minCost2(int n, int[][] cost) {

        long[][][] dp = new long[n / 2 + 1][3][3];

        for (int i = 0; i < n / 2; i++) {

            int[] row1 = cost[i];
            int[] row2 = cost[n - i - 1];

            for (int preJ = 0; preJ < 3; preJ++) {
                for (int preK = 0; preK < 3; preK++) {

                    long ans = Long.MAX_VALUE;
                    for (int j = 0; j < 3; j++) {

                        if (j == preJ) {
                            continue;
                        }

                        for (int k = 0; k < 3; k++) {

                            if (k == preK || k == j) {
                                continue;
                            }

                            ans = Math.min(ans, dp[i][j][k] + row1[j] + row2[k]);
                        }

                    }

                    dp[i + 1][preJ][preK] = ans;
                }
            }

        }

        return Arrays.stream(dp[n / 2]).flatMapToLong(Arrays::stream).min().getAsLong();
    }

}
