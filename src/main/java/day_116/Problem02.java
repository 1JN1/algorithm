package day_116;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/3/25
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        String s = "ccewnxhytsr";

        System.out.println(minInsertions(s));

    }

    public int minInsertions(String s) {

        int len = s.length();

        int left = 0, right = len - 1;
        Map<String, Integer> mem = new HashMap<>();

        return dfs(s, left, right, mem);
    }

    public int dfs(String s, int left, int right, Map<String, Integer> mem) {

        if (left >= right) {
            if (mem.containsKey(left + "_" + right)) {
                return mem.get(left + "_" + right);
            }
            return 0;
        }

        if (s.charAt(left) == s.charAt(right)) {
            if (mem.containsKey(left + "_" + right)) {
                return mem.get(left + "_" + right);
            }
            int num = dfs(s, left + 1, right - 1, mem);
            mem.put(left + "_" + right, num);
            return num;
        }

        if (mem.containsKey(left + "_" + right)) {
            return mem.get(left + "_" + right);
        }
        int num1 = dfs(s, left + 1, right, mem);
        int num2 = dfs(s, left, right - 1, mem);
        mem.put(left + "_" + right, Math.min(num1, num2) + 1);

        return Math.min(num1, num2) + 1;
    }

    public int minInsertions2(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {

            for (int left = 0; left <= n - len; left++) {
                int right = left + len - 1;

                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left + 1][right - 1];
                } else {
                    dp[left][right] = Math.min(dp[left + 1][right], dp[left][right - 1]) + 1;
                }

            }

        }

        return dp[0][n - 1];
    }

}
