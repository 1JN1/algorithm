package day_51;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 王文涛
 * @date 2024/11/16
 * @description 墙与门
 **/
public class Problem02 {

    @Test
    public void test() {

        int[][] rooms = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        wallsAndGates1(rooms);

        System.out.println(Arrays.deepToString(rooms));

    }

    private final int INF = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int d = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            ++d;
            for (int i = q.size(); i > 0; --i) {
                int[] p = q.poll();
                for (int j = 0; j < 4; ++j) {
                    int x = p[0] + dirs[j];
                    int y = p[1] + dirs[j + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = d;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
    }

    public void wallsAndGates1(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        boolean[][] visited;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    visited = new boolean[m][n];
                    dfs(rooms, i, j, 0, visited);
                }
            }
        }

    }

    public void dfs(int[][] rooms, int row, int col, int distance, boolean[][] visited) {

        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || rooms[row][col] == -1 || visited[row][col]) {
            return;
        }


        if (rooms[row][col] == INF) {
            rooms[row][col] = distance;
        } else {
            rooms[row][col] = Math.min(rooms[row][col], distance);
        }

        visited[row][col] = true;

        dfs(rooms, row - 1, col, distance + 1, visited);
        dfs(rooms, row + 1, col, distance + 1, visited);
        dfs(rooms, row, col - 1, distance + 1, visited);
        dfs(rooms, row, col + 1, distance + 1, visited);
    }
}
