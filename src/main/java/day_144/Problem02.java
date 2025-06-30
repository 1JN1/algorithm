package day_144;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/5/23
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(minJumps(arr));
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        // 预处理相同值的位置
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                // 到达终点
                if (current == n - 1) {
                    return steps;
                }

                // 向左跳
                if (current - 1 >= 0 && !visited[current - 1]) {
                    visited[current - 1] = true;
                    queue.offer(current - 1);
                }

                // 向右跳
                if (current + 1 < n && !visited[current + 1]) {
                    visited[current + 1] = true;
                    queue.offer(current + 1);
                }

                // 跳到相同值的位置
                if (valueToIndices.containsKey(arr[current])) {
                    for (int neighbor : valueToIndices.get(arr[current])) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                    // 关键优化：避免重复处理
                    valueToIndices.remove(arr[current]);
                }
            }
            steps++;
        }
        return -1;
    }
}
