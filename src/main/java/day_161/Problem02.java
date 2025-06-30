package day_161;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/21
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public String reversePrefix(String word, char ch) {

        int idx = -1;

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            return word;
        }

        // 逆置0 - idx
        for (int i = 0; i <= idx / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[idx - i];
            chars[idx - i] = temp;
        }

        return new String(chars);
    }

}
