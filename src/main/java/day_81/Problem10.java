package day_81;

/**
 * @author 王文涛
 * @date 2025/2/5
 * @description
 **/
public class Problem10 {


    public void gameOfLife(int[][] board) {

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int num = liveNum(board, i, j);
                // 当前细胞是活细胞
                if (board[i][j] == 1) {

                    if (num == 2 || num == 3) {
                        continue;
                    } else {
                        // 表示活细胞死亡
                        board[i][j] = -1;
                    }

                } else {
                    if (num == 3) {
                        // 死细胞复活
                        board[i][j] = -2;
                    }
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == -2) {
                    board[i][j] = 1;
                }

            }
        }

    }

    public int liveNum(int[][] board, int row, int col) {

        int count = 0;

        int up = Math.max(0, row - 1);
        int down = Math.min(board.length, row + 1);
        int left = Math.max(0, col - 1);
        int right = Math.min(board[0].length, col + 1);

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
