package day_140;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 王文涛
 * @date 2025/5/18
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int n = 20;
        int[][] rides = {
                {1, 6, 1},
                {3, 10, 2},
                {10, 12, 3},
                {11, 12, 2},
                {12, 15, 2},
                {13, 18, 1},
        };
        System.out.println(maxTaxiEarnings(n, rides));
    }

    public long maxTaxiEarnings(int n, int[][] rides) {

        Arrays.sort(rides, Comparator.comparingInt(a -> a[1]));

        int m = rides.length;
        long[] dp = new long[m + 1];

        for (int i = 0; i < m; i++) {
            int start = rides[i][0];
            int j = binarySearch(rides, i, start);
            dp[i + 1] = Math.max(dp[i], dp[j] + rides[i][1] - rides[i][0] + rides[i][2]);
        }

        return dp[m];
    }

    private int binarySearch(int[][] redis, int high, int start) {
        int low = 0;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (redis[mid][1] > start) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
