package day_42;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/7
 * @description 岛屿数量
 **/
public class Problem03 {

    @Test
    public void test() {


        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));

    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 向周围标记
                if (grid[i][j] == '1') {
                    mark(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void mark(char[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            // 向左标记
            mark(grid, row - 1, col);
            // 向右标记
            mark(grid, row + 1, col);
            // 向上标记
            mark(grid, row, col - 1);
            // 向下标记
            mark(grid, row, col + 1);
        }
    }

}
