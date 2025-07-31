package day_179;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/31 10:51
 */
public class Problem03 {

    @Test
    public void test() {

        String s = "(u(love)i)";

        System.out.println(reverseParentheses(s));

    }

    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();

        // 步骤 1: 预处理，找到所有匹配的括号对
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder result = getStringBuilder(s, n, pair);

        return result.toString();
    }

    private static StringBuilder getStringBuilder(String s, int n, int[] pair) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        int direction = 1;

        // 步骤 2: 方向遍历
        while (index < n) {
            char currentChar = s.charAt(index);
            if (currentChar == '(' || currentChar == ')') {
                // 跳转到配对的括号位置
                index = pair[index];
                // 改变方向
                direction = -direction;
            } else {
                result.append(currentChar);
            }
            // 向当前方向移动
            index += direction;
        }
        return result;
    }

}
