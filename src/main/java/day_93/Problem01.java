package day_93;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/23
 * @description
 **/
public class Problem01 {


    @Test
    public void test() {


        System.out.println(maxRepeating("aaaaa", "aa"));
    }

    public int maxRepeating(String sequence, String word) {

        int n = sequence.length(), m = word.length();

        int[] dp = new int[n + 10];
        int max = 0;

        for (int i = 1; i <= n; i++) {

            if (i - m < 0) {
                continue;
            }

            if (sequence.substring(i - m, i).equals(word)) {
                dp[i] = dp[i - m] + 1;
            }
            max = Math.max(max, dp[i]);

        }

        return max;
    }

}
