package day_176;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/26 10:38
 */
public class Problem03 {

    @Test
    public void test() {
        int n = 7;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}
        };
        String labels = "aaabaaa";

        System.out.println(Arrays.toString(countSubTrees(n, edges, labels)));
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] ans = new int[n];
        char[] labelArray = labels.toCharArray();
        dfs(0, -1, graph, labelArray, ans, new int[26]);
        return ans;
    }

    private void dfs(int node, int parent, List<Integer>[] graph,
                     char[] labels, int[] ans, int[] counts) {
        int labelIndex = labels[node] - 'a';
        int before = counts[labelIndex];
        counts[labelIndex]++;

        for (int child : graph[node]) {
            if (child != parent) {
                dfs(child, node, graph, labels, ans, counts);
            }
        }

        ans[node] = counts[labelIndex] - before;
    }
}
