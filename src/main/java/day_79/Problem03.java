package day_79;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/1
 * @description
 **/
public class Problem03 {


    @Test
    public void test() {

        System.out.println(repeatedSubstringPattern("abcabc"));

    }

    public boolean repeatedSubstringPattern(String s) {

        if (s.length() == 1) {
            return false;
        }

        return kmp(s + s, s);
    }

    public boolean kmp(String s, String p) {

        int[] next = buildNext(p);

        int i = 1, j = 0;
        int m = s.length(), n = p.length();

        while (i < m && j < n) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }

            if (j == n - 1) {
                break;
            }
        }

        return (i - j) != n;
    }

    public int[] buildNext(String pattern) {

        int n = pattern.length();
        int[] next = new int[n];
        next[0] = -1;
        int i = 0, j = -1;

        while (i < n - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }

}
