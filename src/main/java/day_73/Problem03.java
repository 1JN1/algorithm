package day_73;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/1/19
 * @description 太平洋大西洋水流问题
 **/
public class Problem03 {

    @Test
    public void test() {

        int[][] heights = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

        System.out.println(pacificAtlantic2(heights));

    }

    int[][] heights;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;

    public List<List<Integer>> pacificAtlantic2(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }

        for (int j = 1; j < n; j++) {
            dfs(0, j, pacific);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }

        for (int j = 0; j < n - 1; j++) {
            dfs(m - 1, j, atlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    public void dfs(int x, int y, boolean[][] ocean) {

        if (ocean[x][y]) {
            return;
        }

        ocean[x][y] = true;

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newX < m && newY >= 0 && newY < n && heights[newX][newY] >= heights[x][y]) {
                dfs(newX, newY, ocean);
            }
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {


        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canPacificOrAtlantic(heights, i, j, true, new boolean[m][n]) && canPacificOrAtlantic(heights, i, j, false, new boolean[m][n])) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    /**
     * 能否流向太平洋或者大西洋
     *
     * @param heights
     * @param x
     * @param y
     * @param flag    true:太平洋 false:大西洋
     * @return
     */
    public boolean canPacificOrAtlantic(int[][] heights, int x, int y, boolean flag, boolean[][] visited) {

        int m = heights.length, n = heights[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        visited[x][y] = true;

        if (flag) {
            if (x == 0 || y == 0) {
                return true;
            }
        } else {
            if (x == m - 1 || y == n - 1) {
                return true;
            }
        }

        boolean left = false, up = false, right = false, down = false;

        if (x - 1 >= 0 && heights[x][y] >= heights[x - 1][y]) {
            up = canPacificOrAtlantic(heights, x - 1, y, flag, visited);
        }

        if (y - 1 >= 0 && heights[x][y] >= heights[x][y - 1]) {
            left = canPacificOrAtlantic(heights, x, y - 1, flag, visited);
        }

        if (x + 1 < m && heights[x][y] >= heights[x + 1][y]) {
            down = canPacificOrAtlantic(heights, x + 1, y, flag, visited);
        }

        if (y + 1 < n && heights[x][y] >= heights[x][y + 1]) {
            right = canPacificOrAtlantic(heights, x, y + 1, flag, visited);
        }

        return left || up || right || down;
    }
}
