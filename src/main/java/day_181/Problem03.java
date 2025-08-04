package day_181;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/4 10:40
 */
public class Problem03 {

    @Test
    public void test() {

        int numCourses = 3;
        int[][] prerequisites = {
                {0, 1},
                {1, 0},
                {1, 2}
        };

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] degrees = new int[numCourses];

        for (int[] pre : prerequisites) {

            int node1 = pre[0];
            int node2 = pre[1];

            graph.computeIfAbsent(node2, key -> new ArrayList<>())
                    .add(node1);
            degrees[node1]++;
        }

        int[] ans = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ans[idx++] = poll;
            List<Integer> edges = graph.get(poll);
            if (edges == null || edges.isEmpty()) {
                continue;
            }
            for (int node : edges) {
                degrees[node]--;
                if (degrees[node] == 0) {
                    queue.offer(node);
                }
            }
        }

        if (idx != numCourses) {
            return new int[]{};
        }

        return ans;
    }

}
