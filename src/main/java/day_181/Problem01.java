package day_181;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/4 9:33
 */
public class Problem01 {

    @Test
    public void test() {

        int[][] isConnected = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        System.out.println(findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {

        int ans = 0;
        int n = isConnected.length;

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, i, visited);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int[][] isConnected, int idx, int[] visited) {

        if (visited[idx] == 1) {
            return;
        }

        visited[idx] = 1;

        int[] edges = isConnected[idx];

        int n = edges.length;

        for (int i = 0; i < n; i++) {
            if (i == idx) {
                continue;
            }
            if (edges[i] == 1) {
                dfs(isConnected, i, visited);
            }
        }

    }

}
