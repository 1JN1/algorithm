package day_58;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/25
 * @description 反转字符串
 **/
public class Problem02 {

    @Test
    public void test() {

        char[] s = {'h', 'e', 'l', 'l', 'o'};

        reverseString(s);

        System.out.println(s);

    }

    public void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {

            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;

        }

    }

}
