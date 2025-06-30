package day_75;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 王文涛
 * @date 2025/1/22
 * @description 无重叠区间
 **/
public class Problem01 {

    @Test
    public void test() {

    }

    /**
     * 按左边界考虑
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[0]));

        int n = intervals.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return n - Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 按右边界考虑
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[1]));

        int ans = 1, right = intervals[0][1], n = intervals.length;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }

        return n - ans;
    }

}
