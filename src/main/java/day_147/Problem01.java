package day_147;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/5/26
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[][] edges = {{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};
        System.out.println(countPairs(7, edges));
    }

    public long countPairs(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        List<Long> counts = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        long totalPairs = 0;
        long totalNodes = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long componentSize = dfs(i, visited, map);
                totalPairs += totalNodes * componentSize;
                totalNodes += componentSize;
            }
        }


        return totalPairs;
    }

    public long dfs(int i, boolean[] visited, Map<Integer, List<Integer>> map) {
        if (visited[i]) {
            return 0;
        }
        visited[i] = true;
        long res = 1;

        for (int edge : map.getOrDefault(i, new ArrayList<>())) {
            res += dfs(edge, visited, map);
        }

        return res;
    }

}
