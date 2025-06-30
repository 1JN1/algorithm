package day_143;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/21
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[][] statements = {{2, 1, 2}, {1, 2, 2}, {2, 0, 2}};

        System.out.println(maximumGood(statements));
    }

    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int max = 0;

        // 尝试所有可能的好人组合（1<<n种可能）
        for (int mask = 0; mask < (1 << n); mask++) {
            if (isValid(mask, statements)) {
                max = Math.max(max, Integer.bitCount(mask));
            }
        }
        return max;
    }

    private boolean isValid(int mask, int[][] statements) {
        int n = statements.length;
        for (int i = 0; i < n; i++) {
            // 如果i是好人，检查他的所有陈述
            if ((mask & (1 << i)) != 0) {
                for (int j = 0; j < n; j++) {
                    if (statements[i][j] != 2 &&
                            ((mask & (1 << j)) == 0) == (statements[i][j] == 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
