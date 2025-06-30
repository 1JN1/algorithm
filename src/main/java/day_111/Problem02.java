package day_111;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/19
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int target = 6;
        int[][] types = {{6, 1}, {3, 2}, {2, 3}};

        System.out.println(waysToReachTarget1(target, types));

    }

    public int waysToReachTarget(int target, int[][] types) {

        int len = types.length;

        int[][] dp = new int[len + 1][target + 1];

        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len; i++) {

            int[] type = types[i - 1];
            int num = type[0];
            int value = type[1];

            for (int j = 1; j <= target; j++) {

                if (j < value) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                for (int k = 0; k <= num && k * value <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k * value]) % 1_000_000_007;
                }

            }

        }

        return dp[len][target];
    }

    public int waysToReachTarget1(int target, int[][] types) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int[] type : types){

            int count = type[0];
            int value = type[1];

            for (int i = target; i > 0; i--){
                for (int j = 1; j <= Math.min(count, i / value); j++) {
                    dp[i] = (dp[i] + dp[i - j * value]) % 1_000_000_007;
                }
            }

        }

        return dp[target];
    }

}
