package day_26;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/12
 * @description 单词搜索
 **/
public class Problem03 {


    @Test
    public void test() {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "BCC"));

    }

    public boolean exist(char[][] board, String word) {

        int m = board.length, n = board[0].length;

        char[] words = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                boolean flag = check(board, words, i, j, 0);
                if (flag) {
                    return true;
                }

            }
        }

        return false;
    }

    /**
     * 检查从i,j位置开始能否找到word
     *
     * @param board 字符矩阵
     * @param words  目标单词
     * @param i     行坐标
     * @param j     列坐标
     * @param len   已满足单词字符路径的长度
     * @return 是否存在路径
     */
    public boolean check(char[][] board, char[] words, int i, int j, int len) {

        if (board[i][j] != words[len]) {
            return false;
        } else if (len == words.length - 1) {
            return true;
        }

        board[i][j] = '\0';

        // 方向矩阵
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        boolean result = false;
        for (int[] direction : directions) {

            // 下一步方向
            int newI = i + direction[0], newJ = j + direction[1];

            // 是一个可行的方向
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[newI].length) {

                if (board[newI][newJ] != '\0') {
                    boolean flag = check(board, words, newI, newJ, len + 1);

                    if (flag) {
                        result = true;
                        break;
                    }

                }

            }
        }

        board[i][j] = words[len];

        return result;
    }
}
