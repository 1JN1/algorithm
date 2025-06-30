package day_12;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/17
 * @description 找出字符串中第一个匹配项的下标
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(strStr("mississippi", "issipi"));

    }

    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()) {
            return -1;
        }

        int i = 0;

        for (; i < haystack.length(); i++) {

            if (match(haystack, needle, i)) {
                return i;
            }

        }

        return -1;
    }

    public boolean match(String haystack, String needle, int begin) {

        int i = 0;

        while (i < needle.length() && (i + begin) < haystack.length()) {

            if (haystack.charAt(i + begin) != needle.charAt(i)) {
                return false;
            }
            i++;

        }

        return i == needle.length();
    }

}
