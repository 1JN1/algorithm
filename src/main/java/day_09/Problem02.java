package day_09;

import org.junit.Test;

import java.util.Stack;

/**
 * @author 王文涛
 * @date 2024/9/14
 * @description 有效的括号
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(isValid("[()]}"));

    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (c == ')' && pop != '(' || c == '}' && pop != '{' || c == ']' && pop != '[') {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

}
