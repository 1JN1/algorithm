package day_98;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/3
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(longestBeautifulSubstring("a"));

    }

    public int longestBeautifulSubstring(String word) {

        int n = word.length();
        int i = 0, j = 0;
        int len = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int idx = 0;

        // 每次从a开始判断
        while (i < n && word.charAt(i) != 'a') {
            i++;
        }

        j = i;

        while (j < n) {
            // 找idx字符
            while (j < n && word.charAt(j) == vowels[idx]) {
                j++;
            }

            idx++;

            // 跳过非元音字母
            while (j < n && !isVowel(word.charAt(j))) {
                j++;
            }


            if (idx == 5 || (j != n && word.charAt(j) != vowels[idx])) {

                if (idx == 5) {
                    len = Math.max(len, j - i);
                }

                // 找到下一个a
                while (j < n && word.charAt(j) != 'a') {
                    j++;
                }

                i = j;
                idx = 0;
            }
        }


        return len;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
