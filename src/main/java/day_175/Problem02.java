package day_175;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/25 10:21
 */
public class Problem02 {

    @Test
    public void test() {

        String a = "a";

        String b = "aa";

        System.out.println(repeatedStringMatch(a, b));
    }

    public int repeatedStringMatch(String a, String b) {
        if (b.isEmpty()) {
            return 0;
        }
        if (a.isEmpty()) {
            return -1;
        }

        int lenA = a.length();
        int lenB = b.length();

        // 理论上最多需要的重复次数
        int maxRepeats = (lenB / lenA) + 2;

        StringBuilder sb = new StringBuilder();

        for (int count = 1; count <= maxRepeats; count++) {
            sb.append(a);

            if (sb.length() >= lenB && sb.toString().contains(b)) {
                return count;
            }
        }

        return -1;
    }


    public int repeatedStringMatch1(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public int strStr(String haystack, String needle) {

        int n = haystack.length(), m = needle.length();

        if (m == 0) {
            return 0;
        }

        int[] next = new int[m + 1];

        for (int i = 1, j = 0; i < m; i++) {

            if (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        // 查询
        for (int i = 0, j = 0; i - j < n; i++) {

            while (j > 0 && haystack.charAt(i % n) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i % n) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i - m + 1;
            }

        }

        return -1;
    }


}
