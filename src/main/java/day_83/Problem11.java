package day_83;

import java.util.PriorityQueue;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem11 {

    public int[] inventoryManagement(int[] stock, int cnt) {


        if (cnt > stock.length) {
            return stock;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < stock.length; i++) {
            pq.add(stock[i]);
        }

        int[] result = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

}
