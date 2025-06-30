package day_141;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 王文涛
 * @date 2025/5/19
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int days = 5;
        int[][] meetings = {
                {2, 4}, {1, 3}
        };
        int ans = countDays(days, meetings);
        System.out.println(ans);
    }

    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        int pre = 0;

        for (int[] meeting : meetings) {
            int start = Math.max(meeting[0], pre);
            int end = meeting[1];

            if (pre > end) {
                continue;
            }

            pre = end + 1;
            count += end - start + 1;
        }

        return days - count;
    }
}
