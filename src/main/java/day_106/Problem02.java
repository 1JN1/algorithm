package day_106;

import org.junit.Test;

import java.util.Stack;

/**
 * @author 王文涛
 * @date 2025/3/13
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        SortedStack sortedStack = new SortedStack();
        System.out.println(sortedStack.peek());


    }


    class SortedStack {

        final Stack<Integer> stack;
        final Stack<Integer> temp;

        public SortedStack() {
            stack = new Stack<>();
            temp = new Stack<>();
        }

        public void push(int val) {

            if (stack.isEmpty()) {
                stack.push(val);
                return;
            }

            // temp中存放比val小的元素
            while (!stack.isEmpty() && stack.peek() < val) {
                temp.push(stack.pop());
            }

            // stack中存放比val大的元素
            while (!temp.isEmpty() && temp.peek() < val) {
                stack.push(temp.pop());
            }

            stack.push(val);
        }

        public void pop() {

            peek();

            if (!stack.isEmpty()) {
                stack.pop();
            }

        }

        public int peek() {

            if (temp.isEmpty()) {
                return stack.isEmpty() ? -1 : stack.peek();
            }

            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }

            return stack.peek();
        }

        public boolean isEmpty() {

            return temp.isEmpty() && stack.isEmpty();
        }
    }

}
