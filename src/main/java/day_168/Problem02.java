package day_168;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author 王文涛
 * @date 2025/7/3
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        String[] nums = {"2","21","12","1"};

        System.out.println(kthLargestNumber(nums, 3));
    }

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return b.compareTo(a);
        });

        for (String num : nums) {
            pq.offer(num);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }

}
