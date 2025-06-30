package day_22;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 王文涛
 * @date 2024/10/6
 * @description 合并区间
 **/
public class Problem01 {

    @Test
    public void test() {

        int[][] ans = merge(new int[][]{
                {1, 4},
                {0, 0}
        });

        System.out.println(Arrays.deepToString(ans));

    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int k = 0;

        for (int i = 1; i < intervals.length; i++) {

            int[] prev = intervals[k], next = intervals[i];

            // 两个区间有重叠
            if (prev[1] >= next[0]) {
                prev[0] = Math.min(prev[0], next[0]);
                prev[1] = Math.max(prev[1], next[1]);
                intervals[k] = prev;
            } else {
                intervals[k] = prev;
                intervals[k + 1] = next;
                k++;
            }

        }

        int[][] res = new int[k + 1][2];

        for (int i = 0; i <= k; i++) {
            res[i] = intervals[i];
        }

        return res;
    }

}
