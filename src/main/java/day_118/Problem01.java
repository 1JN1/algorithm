package day_118;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/4/12
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        String s = "aaaaabbc";

        System.out.println(maxDifference(s));

    }

    public int maxDifference(String s) {

        int[] count = new int[26];

        int len = s.length();

        for (int i = 0; i < len; i++) {

            char ch = s.charAt(i);
            count[ch - 'a']++;
        }

        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for (int i = 0; i < 26; i++) {

            if (count[i] == 0) {
                continue;
            }

            if (count[i] % 2 == 0) {
                minEven = Math.min(minEven, count[i]);
            } else {
                maxOdd = Math.max(maxOdd, count[i]);
            }
        }

        return maxOdd - minEven;
    }

}
