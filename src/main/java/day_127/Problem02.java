package day_127;

/**
 * @author 王文涛
 * @date 2025/4/29
 * @description
 **/
public class Problem02 {

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {

        int n = board.length;

        int[][] directions = {
                {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0},
                {-1, 1}, {0, 1}, {1, 1}
        };

        for (int[] direction : directions){
            if (check(board, rMove, cMove, color, direction[0], direction[1])) {
                return true;
            }
        }

        return false;
    }

    public boolean check(char[][] board, int rMove, int cMove, char color, int dr, int dc) {

        int n = board.length;
        int count = 1;

        int i = rMove + dr;
        int j = cMove + dc;

        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (board[i][j] == '.') {
                break;
            } else if (board[i][j] == color) {
                return count >= 2;
            }
            count++;
            i += dr;
            j += dc;
        }

        return false;
    }

}
