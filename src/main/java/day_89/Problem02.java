package day_89;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/17
 * @description
 **/
public class Problem02 {

    public int minEatingSpeed(int[] piles, int h) {

        int len = piles.length;
        int max = Arrays.stream(piles).max().getAsInt();

        if (len == h) {
            return max;
        }

        int left = 1, right = max;
        while (left < right) {

            int mid = left + (right - left) / 2;
            // 速度为mid，需要多少小时
            int times = 0;
            for (int i = 0; i < len; i++) {
                times += (piles[i] - 1) / mid + 1;
            }

            if (times > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
