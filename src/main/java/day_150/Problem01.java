package day_150;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/30
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        String str = "222222222222222222222222222222222222";
        System.out.println(countTexts(str));
    }

    private static final int MOD = (int) 1e9 + 7;
    private static final int MAX = 10_0001;
    private static final long[] dp3 = new long[MAX];
    private static final long[] dp4 = new long[MAX];
    private static boolean b = false;

    private void init() {

        if (b) {
            return;
        }

        b = true;

        dp3[0] = dp4[0] = 1;
        dp3[1] = dp4[1] = 1;
        dp3[2] = dp4[2] = 2;
        dp3[3] = dp4[3] = 4;

        for (int i = 4; i < MAX; i++) {
            dp3[i] = (dp3[i - 1] + dp3[i - 2] + dp3[i - 3]) % MOD;
            dp4[i] = (dp4[i - 1] + dp4[i - 2] + dp4[i - 3] + dp4[i - 4]) % MOD;
        }

    }

    public int countTexts(String pressedKeys) {

        int len = pressedKeys.length();
        init();

        long ans = 1;
        int cnt = 0;
        char[] s = pressedKeys.toCharArray();

        for (int i = 0; i < len; i++) {
            char c = s[i];
            cnt++;

            if (i == len - 1 || c != s[i + 1]) {
                ans = ans * (c == '7' || c == '9' ? dp4[cnt] : dp3[cnt]) % MOD;
                cnt = 0;
            }
        }

        return (int) ans;
    }

}
