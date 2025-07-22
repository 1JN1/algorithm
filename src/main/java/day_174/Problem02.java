package day_174;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/22 9:59
 */
public class Problem02 {

    @Test
    public void test() {
        System.out.println(isStrictlyPalindromic(9)); // false
        System.out.println(isStrictlyPalindromic(4)); // false
        System.out.println(isStrictlyPalindromic(5)); // false
        System.out.println(isStrictlyPalindromic(6)); // false
        System.out.println(isStrictlyPalindromic(7)); // false
    }

    public boolean isStrictlyPalindromic(int n) {

        for (int b = 2; b < n - 1; b++) {

            String nStr = Integer.toString(n, b);

            if (!isPalindrome(nStr)) {
                return false;
            }
        }

        return true;
    }


    private boolean isPalindrome(String str) {

        char[] chars = str.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) {
                return false;
            }
        }

        return true;
    }

}
