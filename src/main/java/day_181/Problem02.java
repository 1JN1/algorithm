package day_181;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/4 9:42
 */
public class Problem02 {

    @Test
    public void test() {
        int[][] paths = {
                {1, 3, 3},
                {3, 2, 1},
                {2, 1, 3},
                {0, 1, 4},
                {3, 0, 5}
        };
        int cnt = 6;
        int start = 1;
        int end = 0;
        int[] charge = {2, 10, 4, 1};

        System.out.println(electricCarPlan(paths, cnt, start, end, charge));
    }


    public static int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
        int n = charge.length;

        // 构建邻接表表示的图
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            // 无向图构建
            graph.get(path[0]).add(new int[]{path[1], path[2]});
            graph.get(path[1]).add(new int[]{path[0], path[2]});
        }

        // 初始化距离数组：distance[i][j]表示到达城市i时剩余电量为j的最小时间
        int[][] distance = new int[n][cnt + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[start][0] = 0;

        // 访问标记数组
        boolean[][] visited = new boolean[n][cnt + 1];

        // 优先队列，按花费时间排序
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // 元素格式：当前城市、剩余电量、已花费时间
        heap.add(new int[]{start, 0, 0});

        while (!heap.isEmpty()) {
            int[] record = heap.poll();
            int cur = record[0];
            int power = record[1];
            int cost = record[2];

            // 跳过已处理的状态
            if (visited[cur][power]) {
                continue;
            }

            // 到达终点，直接返回当前花费时间
            if (cur == end) {
                return cost;
            }

            visited[cur][power] = true;

            // 选择1：在当前城市充电（每次只充一格电）
            if (power < cnt) {
                int newPower = power + 1;
                int newCost = cost + charge[cur];

                if (!visited[cur][newPower] && newCost < distance[cur][newPower]) {
                    distance[cur][newPower] = newCost;
                    heap.add(new int[]{cur, newPower, newCost});
                }
            }

            // 选择2：前往相邻城市（不充电）
            for (int[] edge : graph.get(cur)) {
                int nextCity = edge[0];
                int needPower = edge[1];
                int restPower = power - needPower;

                if (restPower >= 0) {
                    int nextCost = cost + needPower;

                    if (!visited[nextCity][restPower] && nextCost < distance[nextCity][restPower]) {
                        distance[nextCity][restPower] = nextCost;
                        heap.add(new int[]{nextCity, restPower, nextCost});
                    }
                }
            }
        }

        return -1;
    }


}
