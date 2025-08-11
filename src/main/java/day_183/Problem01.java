package day_183;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/11 9:33
 */
public class Problem01 {

    @Test
    public void test() {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));

        s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));

        s = "()()";
        System.out.println(removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();

        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (openCount > 0) {
                    result.append(c);
                }
                openCount++;
            } else if (c == ')') {
                openCount--;
                if (openCount > 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

}
