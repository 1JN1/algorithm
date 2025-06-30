package day_112;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/3/20
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {2, 3, 5, 6, 7};
        System.out.println(longestSquareStreak(nums));
    }

    public int longestSquareStreak(int[] nums) {

        int len = nums.length;

        Map<Long, Integer> map = new HashMap<>(nums.length);

        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            map.put((long) num, 0);
            max = Math.max(max, num);
        }

        int ans = 0;

        for (long num : nums) {

            int curLen = 1;

            while (true) {

                long next = (long) num * num;

                if (next > max) {
                    break;
                }

                if (map.containsKey(next)) {

                    if (map.get(next) != 0) {
                        curLen += map.get(next);
                        break;
                    }

                    curLen++;
                    num = next;
                } else {
                    break;
                }

            }

            if (curLen > ans) {
                ans = curLen;
            }
        }

        return ans > 1 ? ans : -1;
    }

}
