package day_83;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem06 {

    public String[] findRelativeRanks(int[] score) {

        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int n = score.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {

            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }

        }

        return ans;
    }
}
