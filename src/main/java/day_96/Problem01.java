package day_96;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/25
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
    }

    public String licenseKeyFormatting(String s, int k) {

        int n = s.length();
        StringBuilder builder = new StringBuilder();

        int begin = 0;
        while (begin < n && s.charAt(begin) == '-'){
            begin++;
        }

        int num = 0;
        for (int i = n - 1; i >= begin; i--) {

            if (s.charAt(i) == '-') {
                continue;
            }


            builder.append(Character.toUpperCase(s.charAt(i)));
            num++;

            if (num == k && i != begin) {
                builder.append('-');
                num = 0;
            }


        }

        return builder.reverse().toString();
    }

}
