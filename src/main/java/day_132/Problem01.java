package day_132;

import org.junit.Test;

import java.util.Stack;

/**
 * @author 王文涛
 * @date 2025/5/9
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        String s = "42";
        System.out.println(calculate(s));
    }

    public int calculate(String s) {

        // 生成后缀表达式
        Stack<Character> sign = new Stack<>();
        String[] strings = new String[s.length()];
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '+', '-':
                    while (!sign.isEmpty()) {
                        strings[idx++] = String.valueOf(sign.pop());
                    }
                    sign.push(c);
                    break;
                case '*', '/':
                    while (!sign.isEmpty() && sign.peek() != '+' && sign.peek() != '-') {
                        strings[idx++] = String.valueOf(sign.pop());
                    }
                    sign.push(c);
                    break;
                default:
                    if (Character.isSpaceChar(c)) {
                        continue;
                    }
                    // 数字
                    int[] num = getNum(s, i);
                    strings[idx++] = String.valueOf(num[0]);
                    i = num[1] - 1;
            }

        }

        while (!sign.isEmpty()) {
            strings[idx++] = String.valueOf(sign.pop());
        }

        // 运算
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < idx; i++) {
            String str = strings[i];

            switch (str) {
                case "+":
                    nums.push(nums.pop() + nums.pop());
                    break;
                case "-":
                    nums.push(-nums.pop() + nums.pop());
                    break;
                case "*":
                    nums.push(nums.pop() * nums.pop());
                    break;
                case "/":
                    int a = nums.pop();
                    int b = nums.pop();
                    nums.push(b / a);
                    break;
                default:
                    nums.push(Integer.parseInt(str));
            }
        }

        return nums.pop();
    }

    private int[] getNum(String s, int start) {
        int num = 0;
        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            num = num * 10 + s.charAt(start) - '0';
            start++;
        }
        return new int[]{num, start};
    }

}
