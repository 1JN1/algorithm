package day_130;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/5/5
 * @description
 **/
public class Problem01 {

    public long maximumImportance(int n, int[][] roads) {

        int[] count = new int[n];

        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
        }

        Arrays.sort(count);

        long maxSum = 0;

        for (int i = 0; i < n; i++) {
            maxSum += (long) count[i] * (i + 1);
        }

        return maxSum;
    }

}
