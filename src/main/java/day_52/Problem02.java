package day_52;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/17
 * @description 生命游戏
 **/
public class Problem02 {

    @Test
    public void test() {

        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        gameOfLife(board);

        System.out.println(Arrays.deepToString(board));

    }

    public void gameOfLife(int[][] board) {

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 活细胞数目
                int liveNum = liveNum(board, i, j);

                if (board[i][j] == 0) {
                    if (liveNum == 3) {
                        // 暂时用-2表示复活的死细胞
                        board[i][j] = -2;
                    }
                } else {

                    if (liveNum < 2 || liveNum > 3) {
                        // 暂时用-1表示死亡的活细胞
                        board[i][j] = -1;
                    }

                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }

    }

    public int liveNum(int[][] board, int row, int col) {

        int count = 0;

        int up = Math.max((row - 1), 0);
        int down = Math.min((row + 1), board.length - 1);
        int left = Math.max((col - 1), 0);
        int right = Math.min((col + 1), board[0].length - 1);

        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {

                if (i == row && j == col) {
                    continue;
                }

                if (board[i][j] == 1 || board[i][j] == -1) {
                    count++;
                }
            }
        }

        return count;
    }

}
