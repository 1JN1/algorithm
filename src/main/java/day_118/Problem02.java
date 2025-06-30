package day_118;

import org.junit.Test;

import java.util.Stack;

/**
 * @author 王文涛
 * @date 2025/4/12
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(minLength2("ABFCACDB"));
        System.out.println(minLength2("ACBBD"));
    }

    public int minLength(String s) {

        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");
            s = s.replace("CD", "");
        }

        return s.length();
    }

    public int minLength2(String s) {

        int ans = s.length();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == 'B') {
                if (!stack.isEmpty() && stack.peek() == 'A') {
                    stack.pop();
                    ans -= 2;
                } else {
                    stack.push(chars[i]);
                }
            } else if (chars[i] == 'D') {
                if (!stack.isEmpty() && stack.peek() == 'C') {
                    stack.pop();
                    ans -= 2;
                } else {
                    stack.push(chars[i]);
                }
            } else {
                stack.push(chars[i]);
            }
        }

        return ans;
    }

}
