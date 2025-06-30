package day_38;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/2
 * @description 最小栈
 **/
public class Problem05 {

    @Test
    public void test() {

        MinStack obj = new MinStack();

        obj.push(-2);
        obj.push(0);
        obj.push(-3);

        System.out.println(obj.getMin());

        obj.pop();

        System.out.println(obj.top());

        System.out.println(obj.getMin());

    }

    class MinStack {

        private static final int MAX_LEN = 30001;
        private int[] data = new int[MAX_LEN];
        private int[] min = new int[MAX_LEN];
        private int top = -1;

        public MinStack() {

        }

        public void push(int val) {

            if (top < MAX_LEN - 1) {
                int minVal = val;
                if (top >= 0) {
                    minVal = Math.min(val, min[top]);
                }

                data[++top] = val;
                min[top] = minVal;
            }

        }

        public void pop() {

            if (top == -1) {
                return;
            }

            data[top] = 0;
            min[top--] = 0;

        }

        public int top() {

            return data[top];
        }

        public int getMin() {

            return min[top];
        }
    }

}
