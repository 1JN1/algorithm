package day_28;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/14
 * @description 解码方法
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(numDecodings("11106"));

    }

    public int numDecodings(String s) {

        // a表示上上一次的编码方式数目， b表示上一次的编码方式数目，c表示本次编码方式的数目
        int a = 0, b = 1, c = 0;

        for (int i = 1; i <= s.length(); i++) {

            c = 0;

            if (s.charAt(i - 1) != '0') {
                c += b;
            }

            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0') <= 26) {
                c += a;
            }

            a = b;
            b = c;
        }

        return c;
    }

}
