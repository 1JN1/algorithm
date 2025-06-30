package day_156;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/9
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(numSub("000"));
    }

    static final int MOD = 1_000_000_007;

    public int numSub(String s) {

        long ans = 0;

        int count = 0;

        char[] chars = s.toCharArray();
        int idx = 0, n = chars.length;

        while (idx < n) {
            while (idx < n && chars[idx] == '0') {
                idx++;
            }
            while (idx < n && chars[idx] == '1') {
                count++;
                idx++;
            }

            ans += ((long) (count + 1) * count / 2) % MOD;
            count = 0;
        }

        return (int) (ans % MOD);
    }

}
