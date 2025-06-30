package day_133;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/10
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int m = 3;
        int n = 3;
        int[][] ops = {};
        System.out.println(maxCount(m, n, ops));
    }

    public int maxCount(int m, int n, int[][] ops) {

        int preX = m;
        int preY = n;

        for (int[] op : ops) {
            preX = Math.min(preX, op[0]);
            preY = Math.min(preY, op[1]);
        }

        return preX * preY;
    }
}
