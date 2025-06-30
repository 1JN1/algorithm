package day_29;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/15
 * @description 不同的二叉搜索树
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(numTrees(3));

    }

    public int numTrees(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= i; j++) {

                dp[i] += dp[j - 1] * dp[i - j];

            }

        }

        return dp[n];

    }

}
