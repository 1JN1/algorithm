package day_25;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/11
 * @description 爬楼梯
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(climbStairs(45));
        System.out.println(climbStairs2(45));

    }

    public int climbStairs(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairs2(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int p = 1, q = 2, r = 0;

        for (int i = 3; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }

        return r;
    }

}
