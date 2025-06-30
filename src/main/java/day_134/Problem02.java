package day_134;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/11
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(findTheLongestBalancedSubstring("00111"));
    }

    public int findTheLongestBalancedSubstring(String s) {

        int maxLen = 0;

        int idx = 0;
        while (idx < s.length()) {
            int len = 0;

            while (idx < s.length() && s.charAt(idx) == '0') {
                idx++;
                len++;
            }
            // 匹配对应数量的1
            int len1 = 0;
            while (idx < s.length() && s.charAt(idx) == '1') {
                idx++;
                len1++;
            }
            if (len1 > len) {
                len1 = len;
            }
            maxLen = Math.max(maxLen, len1 * 2);
        }

        return maxLen;
    }
}
