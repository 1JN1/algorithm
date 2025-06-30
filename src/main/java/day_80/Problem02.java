package day_80;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/2
 * @description
 **/
public class Problem02 {


    @Test
    public void test() {

        System.out.println(findSubstringInWraproundString("zab"));

    }

    public int findSubstringInWraproundString(String s) {

        int[] dp = new int[26];

        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && isAdjacent(s.charAt(i - 1), s.charAt(i))) {
                len++;
            } else {
                len = 1;
            }

            char ch = s.charAt(i);
            dp[ch - 'a'] = Math.max(len, dp[ch - 'a']);
        }

        return Arrays.stream(dp).sum();
    }

    public boolean isAdjacent(Character a, Character b) {
        return a == 'z' ? b == 'a' : a + 1 == b;
    }

}
