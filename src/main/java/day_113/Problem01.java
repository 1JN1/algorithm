package day_113;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/3/21
 * @description
 **/
public class Problem01 {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        // 存放两种颜色的边
        List<Integer>[][] next = new List[2][n];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {

                next[i][j] = new ArrayList<>();

            }
        }

        // 填充红色边
        for (int[] redEdge : redEdges) {
            next[0][redEdge[0]].add(redEdge[1]);
        }

        // 填充蓝色边
        for (int[] blueEdge : blueEdges) {
            next[1][blueEdge[0]].add(blueEdge[1]);
        }

        // 存放两种情况下的最短路径
        // 1. 到目标节点为红色边
        // 2. 到目标节点为蓝色边
        int[][] dist = new int[2][n];

        // 初始化路径数组
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // 0 -> 0 的最短路径为1
        dist[0][0] = 0;
        dist[1][0] = 0;

        // BFS访问边
        Queue<int[]> queue = new ArrayDeque<>();

        // 第一个位置表示当前节点，第二个位置表示当前节点的颜色
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curNode = cur[0], curColor = cur[1];
            for (int nextNode : next[1 - curColor][curNode]) {
                // BFS 保证了第一次访问到这个节点时一定是最短路径，所以如果已经访问过这个节点了，可以直接跳过
                if (dist[1 - curColor][nextNode] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[1 - curColor][nextNode] = dist[curColor][curNode] + 1;
                queue.add(new int[]{nextNode, 1 - curColor});
            }

        }

        // 答案
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(dist[0][i], dist[1][i]);
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }

        return ans;
    }

}
