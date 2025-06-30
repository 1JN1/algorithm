package day_46;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 王文涛
 * @date 2024/11/11
 * @description 用队列实现栈
 **/
public class Problem01 {

    @Test
    public void test() {

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());

    }

    class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {

            q1 = new LinkedList<>();
            q2 = new LinkedList<>();

        }

        public void push(int x) {

            q2.offer(x);

            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

        }

        public int pop() {

            return q1.poll();
        }

        public int top() {

            return q1.peek();
        }

        public boolean empty() {

            return q1.isEmpty();
        }
    }

}
