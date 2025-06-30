package day_59;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/26
 * @description 数据流中的移动平均值
 **/
public class Problem02 {

    @Test
    public void test() {

        MovingAverage movingAverage = new MovingAverage(3);

        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));

    }

    class MovingAverage {

        /**
         * 总数据个数
         */
        private int count;
        /**
         * 数据和
         */
        private int sum;
        /**
         * 窗口元素
         */
        private int[] nums;


        public MovingAverage(int size) {

            this.nums = new int[size];
            this.count = 0;
            this.sum = 0;

        }

        public double next(int val) {

            int idx = count % nums.length;

            sum += val - nums[idx];

            nums[idx] = val;

            count++;

            return sum * 1.0 / Math.min(count, nums.length);
        }
    }

}
