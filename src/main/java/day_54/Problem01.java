package day_54;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/19
 * @description 最佳买卖股票时机含冷冻期
 **/
public class Problem01 {

    @Test
    public void test() {

    }

    public int maxProfit(int[] prices) {


        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;

        int dp1 = -prices[0], dp2 = 0, dp3 = 0;

        for (int i = 1; i < n; i++) {

            int temp1 = Math.max(dp1, dp3 - prices[i]);
            int temp2 = dp1 + prices[i];
            int temp3 = Math.max(dp2, dp3);

            dp1 = temp1;
            dp2 = temp2;
            dp3 = temp3;

        }

        return Math.max(dp2, dp3);
    }

}
