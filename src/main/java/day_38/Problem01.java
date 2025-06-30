package day_38;

import org.junit.Test;

import java.util.Stack;

/**
 * @author 王文涛
 * @date 2024/11/2
 * @description 逆波兰表达式求值
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));

    }

    public int evalRPN(String[] tokens) {

        if (tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            int a = 0, b = 0;
            switch (token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }

        }

        return stack.pop();
    }

}
