package day_186;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/22 9:41
 */
public class Problem02 {

    @Test
    public void test() {
        String[] matrix = {
                "sd",
                "ep"
        };
        String mantra = "speed";
        int result = extractMantra(matrix, mantra);
        System.out.println(result);
    }

    /**
     * m: 矩阵行数
     * n: 矩阵列数
     */
    int m, n;

    /**
     * d: 用于表示上、下、左、右四个方向的移动向量。
     * d[i], d[i+1] 构成一个方向。
     */
    int[] d = new int[]{0, 1, 0, -1, 1, 0, -1, 0};

    /**
     * 使用广度优先搜索 (BFS) 计算提取 mantra 的最小成本。
     *
     * @param matrix 字符矩阵
     * @param mantra 目标字符串
     * @return 最小成本，如果无法完成则返回 -1
     */
    public int extractMantra(String[] matrix, String mantra) {
        this.m = matrix.length;
        if (m == 0) {
            return mantra.isEmpty() ? 0 : -1;
        }
        this.n = matrix[0].length();
        int k = mantra.length();

        /*
         * visit 数组用于记录一个状态是否被访问过，防止重复搜索。
         * 状态由两部分组成：(当前mantra的索引, 当前在矩阵中的位置)。
         * visit[i][j] == true 表示“当寻找mantra[i]时，(x,y)位置已经被访问过”。
         */
        boolean[][] visit = new boolean[k + 1][m * n];

        /*
         * BFS 核心队列。
         * 存储的数组 int[] 包含四个核心信息: {总成本, mantra索引, x坐标, y坐标}
         */
        Queue<int[]> queue = new LinkedList<>();

        // 1. 初始化：将起点加入队列
        // 成本为0, 寻找mantra[0], 起始位置在(0,0)
        queue.add(new int[]{0, 0, 0, 0});
        visit[0][index(0, 0)] = true;

        // 2. 开始 BFS 循环
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cost = current[0];
            int mantraIndex = current[1];
            int x = current[2];
            int y = current[3];

            // 3. 检查是否到达终点
            // 如果 mantraIndex 等于 k，说明所有字符都已成功提取
            if (mantraIndex == k) {
                // 因为 BFS 的特性，第一个到达终点的路径必然是成本最小的
                return cost;
            }

            // 4. 探索邻近状态（两种操作）

            // ## 操作 A: 在网格上移动 (同层探索) ##
            // 成本 +1, mantraIndex 不变, (x,y) 改变
            for (int i = 0; i < 8; i += 2) {
                int nextX = x + d[i];
                int nextY = y + d[i + 1];
                int nextPos = index(nextX, nextY);

                // 检查是否越界以及该状态是否已访问
                if (range(nextX, nextY) && !visit[mantraIndex][nextPos]) {
                    visit[mantraIndex][nextPos] = true;
                    queue.add(new int[]{cost + 1, mantraIndex, nextX, nextY});
                }
            }

            // ## 操作 B: 提取字符 (跨层探索) ##
            // 成本 +1, mantraIndex + 1, (x,y) 不变
            // 仅当当前位置的字符匹配时才能执行
            if (matrix[x].charAt(y) == mantra.charAt(mantraIndex)) {
                int nextMantraIndex = mantraIndex + 1;
                int currentPos = index(x, y);

                // **【修正点】**：检查并更新下一层的 visit 状态
                if (!visit[nextMantraIndex][currentPos]) {
                    visit[nextMantraIndex][currentPos] = true;
                    queue.add(new int[]{cost + 1, nextMantraIndex, x, y});
                }
            }
        }

        // 5. 如果队列为空仍未找到路径，说明无法完成
        return -1;
    }

    /**
     * 辅助函数：检查坐标是否在矩阵范围内
     */
    private boolean range(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    /**
     * 辅助函数：将二维坐标 (x, y) 转换为一维索引
     */
    private int index(int x, int y) {
        if (!range(x, y)) return -1; // 增加保护
        return x * n + y;
    }
}
