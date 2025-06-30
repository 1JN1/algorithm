package day_69;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/14
 * @description
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(isSubsequence("aza", "abzba"));

    }

    public boolean isSubsequence(String s, String t) {


        int begin = 0;
        for (int i = 0; i < s.length(); i++) {

            boolean flag = false;
            for (int j = begin; j < t.length(); j++) {

                if (s.charAt(i) == t.charAt(j)) {
                    begin = j + 1;
                    flag = true;
                    break;
                }

            }

            if (!flag) {
                return false;
            }

        }

        return true;
    }

    public boolean isSubsequence2(String s, String t) {

        int n = s.length(), m = t.length();
        int i = 0, j = 0;

        while (i < n && j < m) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == n;
    }

}
