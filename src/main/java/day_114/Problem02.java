package day_114;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/23
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(valueAfterKSeconds(4, 3));

    }

    private static final int MOD = 1_000_000_007;
    private static final int MX = 2001;

    // 组合数模板
    private static final long[] FAC = new long[MX];
    private static final long[] INV_FAC = new long[MX];

    static {
        FAC[0] = 1;
        for (int i = 1; i < MX; i++) {
            FAC[i] = FAC[i - 1] * i % MOD;
        }
        INV_FAC[MX - 1] = pow(FAC[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            INV_FAC[i - 1] = INV_FAC[i] * i % MOD;
        }
    }

    private static long comb(int n, int k) {
        return FAC[n] * INV_FAC[k] % MOD * INV_FAC[n - k] % MOD;
    }

    public int valueAfterKSeconds(int n, int k) {
        return (int) comb(n + k - 1, k);
    }

    private static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }
}
