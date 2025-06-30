package day_55;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/20
 * @description 零钱兑换
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(coinChange(new int[]{2}, 3));

    }

    public int coinChange(int[] coins, int amount) {


        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            int count = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    count = Math.min(count, 1 + dp[i - coin]);
                }
            }
            dp[i] = count;

        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }

}
