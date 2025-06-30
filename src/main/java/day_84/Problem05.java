package day_84;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/2/10
 * @description
 **/
public class Problem05 {

    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            // 两个区间有重叠
            if (intervals[i][0] <= current[1]) {
                // 右端点取较大的那个
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }

        }

        result.add(current);


        return result.toArray(new int[result.size()][2]);
    }

}
