package day_121;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/4/15
 * @description
 **/
public class Problem01 {

    class RecentCounter {

        int[] requests;
        int head = 0;
        int tail = 0;

        public RecentCounter() {
            requests = new int[10000];
        }

        public int ping(int t) {

            // 移动头，把时间范围外的请求排除
            while (head < tail && requests[head] < (t - 3000)) {
                head++;
            }

            requests[tail++] = t;

            return tail - head;
        }
    }

    @Test
    public void test() {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

}
