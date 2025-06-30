package day_33;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/21
 * @description 买卖股票的最佳时机II
 **/
public class Problem04 {

    @Test
    public void test() {

    }

    public int maxProfit(int[] prices) {

        // 前一天不持有股票
        int dp0 = 0;
        // 前一天持有股票
        int dp1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);

            dp0 = newDp0;
            dp1 = newDp1;

        }

        return Math.max(dp0, dp1);
    }

    public int maxProfit2(int[] prices) {

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            maxProfit += Math.max(0, prices[i] - prices[i - 1]);

        }

        return maxProfit;
    }

}
