package day_33;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/21
 * @description 买卖股票的最佳时机
 **/
public class Problem03 {

    @Test
    public void test() {

        int[] prices = {8, 2, 3, 1, 12, 9};

        System.out.println(maxProfit(prices));

    }

    public int maxProfit(int[] prices) {

        // 当前位置前，最低的股票价格
        int minPrice = prices[0];
        // 最大利润
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }

        }

        return maxProfit;
    }

}
