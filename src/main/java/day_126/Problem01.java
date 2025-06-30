package day_126;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 王文涛
 * @date 2025/4/27
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[][] orders = {{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};

        System.out.println(getNumberOfBacklogOrders(orders));
    }

    public int getNumberOfBacklogOrders(int[][] orders) {

        int mod = (int) 1e9 + 7;

        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] order : orders) {

            int price = order[0];
            int amount = order[1];
            int type = order[2];

            // 采购订单
            if (type == 0) {

                while (amount > 0 && !sell.isEmpty()) {
                    int[] top = sell.peek();
                    if (top[0] <= price) {
                        int min = Math.min(amount, top[1]);
                        amount -= min;
                        top[1] -= min;
                        if (top[1] == 0) {
                            sell.poll();
                        }
                    } else {
                        break;
                    }
                }

                if (amount > 0) {
                    buy.offer(new int[]{price, amount});
                }
            } else {
                while (amount > 0 && !buy.isEmpty()) {
                    int[] top = buy.peek();
                    if (top[0] >= price) {
                        int min = Math.min(amount, top[1]);
                        amount -= min;
                        top[1] -= min;
                        if (top[1] == 0) {
                            buy.poll();
                        }
                    } else {
                        break;
                    }
                }
                if (amount > 0) {
                    sell.offer(new int[]{price, amount});
                }
            }
        }

        int ans = 0;
        while (!buy.isEmpty()) {
            int[] top = buy.poll();
            ans += top[1];
            ans %= mod;
        }
        while (!sell.isEmpty()) {
            int[] top = sell.poll();
            ans += top[1];
            ans %= mod;
        }

        return ans;
    }

}
