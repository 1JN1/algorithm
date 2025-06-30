package day_90;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/18
 * @description
 **/
public class Problem03 {

    @Test
    public void test() {

        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        int m = 2;
        int k = 3;

        System.out.println(minDays(bloomDay, m, k));

    }

    public int minDays(int[] bloomDay, int m, int k) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = bloomDay.length;

        if ((long)m * k > n) {
            return -1;
        }

        for (int i = 0; i < n; i++) {

            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);

        }

        int left = min, right = max;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (check(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return check(bloomDay, m, k, left) ? left : -1;
    }

    public boolean check(int[] bloomDay, int m, int k, int mid) {

        int count = 0;
        int n = bloomDay.length;

        for (int j = 0; j < n; j++) {

            if (bloomDay[j] <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                m--;
                count = 0;
            }

            if (m == 0) {
                return true;
            }

        }


        return false;
    }

}
