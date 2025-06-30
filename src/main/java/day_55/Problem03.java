package day_55;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/20
 * @description
 **/
public class Problem03 {

    @Test
    public void test() {


        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
        };

        System.out.println(countComponents(5, edges));
    }

    public int countComponents(int n, int[][] edges) {

        int count = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(edges, i, visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(int[][] edges, int i, boolean[] visited) {

        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (int[] edge : edges) {

            if (edge[0] == i) {
                dfs(edges, edge[1], visited);
            } else if (edge[1] == i) {
                dfs(edges, edge[0], visited);
            }

        }

    }

}
