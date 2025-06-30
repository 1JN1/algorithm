package day_61;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/28
 * @description 安卓系统手势解锁
 **/
public class Problem02 {

    @Test
    public void test() {

        int total = 0;
        for (int m = 1; m < 10; m++) {
            for (int n = m; n < 10; n++) {
                total += numberOfPatterns(m, n);
            }
        }

        System.out.println(total);

    }


    /**
     * 记录数字有没有被访问过
     */
    private boolean[] visited = new boolean[10];
    /**
     * 记录两个数字间的中间数字
     */
    private int[][] cross = new int[10][10];

    public int numberOfPatterns(int m, int n) {

        cross[1][3] = cross[3][1] = 2;
        cross[1][7] = cross[7][1] = 4;
        cross[1][9] = cross[9][1] = 5;
        cross[2][8] = cross[8][2] = 5;
        cross[3][7] = cross[7][3] = 5;
        cross[3][9] = cross[9][3] = 6;
        cross[4][6] = cross[6][4] = 5;
        cross[7][9] = cross[9][7] = 8;

        return dfs(1, 1, m, n) * 4 + dfs(2, 1, m, n) * 4 + dfs(5, 1, m, n);
    }

    public int dfs(int idx, int cnt, int m, int n) {

        if (cnt > n) {
            return 0;
        }

        visited[idx] = true;
        int num = cnt >= m ? 1 : 0;
        for (int i = 0; i < 10; i++) {

            int middle = cross[idx][i];

            boolean flag = !visited[i] && (middle == 0 || visited[middle]);
            if (flag) {
                num += dfs(i, cnt + 1, m, n);
            }

        }

        // 回溯
        visited[idx] = false;
        return num;
    }


}
