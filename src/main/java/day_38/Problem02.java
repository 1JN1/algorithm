package day_38;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 王文涛
 * @date 2024/11/2
 * @description 反转字符串中的单词
 **/
public class Problem02 {

    @Test
    public void test() {

        String s = "a good   example";

        System.out.println(reverseWords(s));

    }

    public String reverseWords(String s) {

        s = s.trim();

        String[] strings = s.split(" ");

        StringBuilder builder = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {

            if (strings[i].isEmpty()) {
                continue;
            }

            if (i != 0) {
                builder.append(strings[i]).append(" ");
            } else {
                builder.append(strings[i]);
            }

        }

        return builder.toString();
    }


}
