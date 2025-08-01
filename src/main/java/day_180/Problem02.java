package day_180;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/1 9:58
 */
public class Problem02 {

    @Test
    public void test() {
        int n = 2;
        int[][] relations = {{2, 1}};
        int[] time = {10000, 10000};
        System.out.println(minimumTime(n, relations, time));
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        // 1. 构建图和入度数组
        // graph 的 key 是前置课程, value 是依赖这门课的后续课程列表
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            graph.get(prev).add(next);
            inDegree[next]++;
        }

        // 2. 初始化dp数组和队列
        // dp[i] 表示完成课程 i 的最早时间
        int[] dp = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                // 将所有没有前置依赖的课程（入度为0）加入队列
                queue.offer(i);
                // 其完成时间就是它自身所需的时间
                dp[i] = time[i - 1];
            }
        }

        // 3. 拓扑排序 + 动态规划
        int maxTime = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();

            maxTime = Math.max(maxTime, dp[currentCourse]);
            // 遍历所有依赖 currentCourse 的后续课程
            for (int nextCourse : graph.get(currentCourse)) {
                // 更新后续课程的最早完成时间
                // 它等于 (所有前置课程的最晚完成时间 + 自己的时间)
                dp[nextCourse] = Math.max(dp[nextCourse], dp[currentCourse] + time[nextCourse - 1]);

                // 后续课程的入度减1
                inDegree[nextCourse]--;
                // 如果入度变为0，说明它的所有前置课程都已完成，可以入队了
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }


        return maxTime;
    }

}
