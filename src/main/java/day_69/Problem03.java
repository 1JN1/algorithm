package day_69;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/14
 * @description
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(findTheDifference2("abcd", "abbcd"));

    }

    public char findTheDifference(String s, String t) {


        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {

            int num = count[t.charAt(i) - 'a']--;

            if (num == 0) {
                return t.charAt(i);
            }

        }

        return 0;
    }

    public char findTheDifference2(String s, String t) {

        int num = 0;

        for (int i = 0; i < t.length(); i++) {
            num += t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            num -= s.charAt(i);
        }

        return (char) num;
    }

}
