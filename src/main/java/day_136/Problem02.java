package day_136;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/13
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenter(edges));
    }

    public int findCenter(int[][] edges) {

        int n = edges.length + 1;
        int[] counts = new int[n + 1];

        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (counts[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
