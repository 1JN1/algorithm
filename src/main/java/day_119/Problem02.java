package day_119;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/4/13
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(compareVersion("1.0", "1.0.0.0"));

    }

    public int compareVersion(String version1, String version2) {

        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");

        int len = Math.max(strings1.length, strings2.length);

        for (int i = 0; i < len; i++) {

            String s1 = i < strings1.length ? strings1[i] : "0";
            String s2 = i < strings2.length ? strings2[i] : "0";

            int num1 = strToInt(s1);
            int num2 = strToInt(s2);

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }

        return 0;
    }

    public int strToInt(String s) {

        // 去掉前导0
        int len = s.length();
        int i = 0;
        while (i < len && s.charAt(i) == '0') {
            i++;
        }

        if (i == len) {
            return 0;
        }

        s = s.substring(i);

        return Integer.parseInt(s);
    }
}
