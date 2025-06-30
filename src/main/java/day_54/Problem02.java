package day_54;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/11/19
 * @description 最小高度树
 **/
public class Problem02 {

    @Test
    public void test() {

        int[][] edges = {
                {0, 1},
                {0, 2}
        };

        System.out.println(findMinHeightTrees1(3, edges));

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int minHigh = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            boolean[] visited = new boolean[n];

            int high = getHigh(edges, i, visited);

            map.computeIfAbsent(high, k -> new ArrayList<>()).add(i);

            minHigh = Math.min(minHigh, high);

        }

        return map.get(minHigh);
    }

    public int getHigh(int[][] edges, int n, boolean[] visited) {

        int high = 0;

        if (visited[n]) {
            return high;
        }

        visited[n] = true;

        for (int i = 0; i < edges.length; i++) {

            int high1 = 0;

            if (edges[i][0] == n && !visited[edges[i][1]]) {
                high1 = getHigh(edges, edges[i][1], visited);
            } else if (edges[i][1] == n && !visited[edges[i][0]]) {
                high1 = getHigh(edges, edges[i][0], visited);
            }

            high = Math.max(high, high1);
        }

        return high + 1;
    }

    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {

        List<Integer> ans = new ArrayList<>();

        if (n == 1) {
            ans.add(0);
            return ans;
        }

        List<Integer>[] adj = new List[n];
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 度为1的节点入队
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        int remainNodes = n;

        while (remainNodes > 2) {

            int size = queue.size();

            remainNodes -= size;

            for (int i = 0; i < size; i++) {

                int cur = queue.poll();

                for (Integer integer : adj[cur]) {
                    degree[integer]--;
                    if (degree[integer] == 1) {
                        queue.add(integer);
                    }
                }

            }

        }

        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }

        return ans;
    }
}
