package day_33;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/21
 * @description 三角形的最小路径和
 **/
public class Problem02 {

    @Test
    public void test() {

        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal3(triangle));
    }


    public int minimumTotal2(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {

            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);

            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }

            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);

        }

        int min = dp[n - 1][0];

        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }

    public int minimumTotal3(List<List<Integer>> triangle) {

        int n = triangle.size();

        if (n == 1) {
            return triangle.get(0).get(0);
        }

        int[] pre = new int[n];
        int[] now = new int[n];

        pre[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {

            now[0] = pre[0] + triangle.get(i).get(0);

            for (int j = 1; j < i; j++) {
                now[j] = Math.min(pre[j - 1], pre[j]) + triangle.get(i).get(j);
            }

            now[i] = pre[i - 1] + triangle.get(i).get(i);

            if (i < n - 1) {
                int[] temp = pre;
                pre = now;
                now = temp;
            }
        }

        int min = now[0];

        for (int i = 1; i < n; i++) {
            min = Math.min(min, now[i]);
        }

        return min;
    }

}
