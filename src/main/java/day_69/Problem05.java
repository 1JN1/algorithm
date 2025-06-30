package day_69;

import org.junit.Test;

import java.util.Stack;

/**
 * @author 王文涛
 * @date 2025/1/14
 * @description
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(decodeString("100[leetcode]"));

    }

    public String decodeString(String s) {

        StringBuffer sb = new StringBuffer();

        dfs(s, sb, 0, s.length() - 1);

        return sb.toString();
    }

    public void dfs(String s, StringBuffer sb, int begin, int end) {

        if (begin > end) {
            return;
        }

        for (int i = begin; i <= end; i++) {

            char ch = s.charAt(i);

            if (!Character.isDigit(ch)) {
                sb.append(ch);
            } else {

                // 找出完整的数字（可能不止一位）
                int num = ch - '0';
                for (int j = i + 1; j <= end; j++) {

                    if (s.charAt(j) != '[') {
                        num = num * 10 + s.charAt(j) - '0';
                    } else {
                        i = j - 1;
                        break;
                    }

                }

                // 利用栈找出匹配的]对应的下标
                int idx = i + 1;
                Stack<Character> stack = new Stack<>();

                while (idx <= end) {

                    if (s.charAt(idx) == '[') {
                        stack.push('[');
                    } else if (s.charAt(idx) == ']') {
                        stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }

                    idx++;

                }

                StringBuffer temp = new StringBuffer();
                dfs(s, temp, i + 2, idx - 1);

                for (int j = 0; j < num; j++) {
                    sb.append(temp);
                }

                i = idx;
            }

        }

    }

}
