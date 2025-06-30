package day_46;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/11/11
 * @description 基本计算器II
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(calculate2("42"));

    }

    public int calculate(String s) {


        // 操作数栈
        Stack<Integer> stack = new Stack<>();
        // 所有的操作数
        List<Integer> nums = new ArrayList<>();
        // 符号栈，将符号转换为后缀表达
        Stack<Character> sign = new Stack<>();
        // 存放符号位优先级
        Map<Character, Integer> map = new HashMap<>();
        // 后缀表达式中的符号位
        StringBuilder post = new StringBuilder();
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // 扫描到符号位
            if (!Character.isDigit(c) && c != ' ') {

                while (!sign.isEmpty() && map.get(sign.peek()) >= map.get(c)) {
                    post.append(sign.pop());
                }

                sign.push(c);

            } else if (c != ' ') {
                StringBuilder builder = new StringBuilder();

                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    builder.append(s.charAt(j++));
                }

                i = j - 1;
                // 使用特殊字符N表示这里是一个数字
                post.append("N");
                int num = Integer.parseInt(builder.toString());
                nums.add(num);
            }

        }


        while (!sign.isEmpty()) {
            post.append(sign.pop());
        }

        String postStr = post.toString();


        int num1, num2;
        int idx = 0;

        for (int i = 0; i < postStr.length(); i++) {

            char c = postStr.charAt(i);

            if (c == 'N') {
                stack.push(nums.get(idx++));
            } else {
                num1 = stack.pop();
                num2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }


        }


        return stack.pop();
    }

    public int calculate2(String s) {

        Stack<Integer> stack = new Stack<>();
        char preStr = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {

                switch (preStr) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                }

                preStr = c;
                num = 0;

            }

        }

        num = 0;
        while (!stack.isEmpty()) {
            num += stack.pop();
        }

        return num;
    }
}
