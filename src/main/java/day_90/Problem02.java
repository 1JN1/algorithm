package day_90;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/18
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] weights = {1,2,3,1,1};
        int days = 4;

        System.out.println(shipWithinDays(weights, days));

    }

    public int shipWithinDays(int[] weights, int days) {

        int max = Integer.MIN_VALUE, sum = 0, n = weights.length;

        for (int i = 0; i < n; i++) {

            max = Math.max(max, weights[i]);
            sum += weights[i];

        }

        int left = max, right = sum;

        while (left < right) {

            int mid = left + (right - left) / 2;
            if (check(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }


        }

        return left;
    }

    public boolean check(int[] weights, int days, int mid) {

        int cnt = 0, idx = 0, n = weights.length, sum = 0;

        while (idx < n) {

            if (sum + weights[idx] > mid) {
                cnt++;
                sum = 0;
            }

            sum += weights[idx++];

        }

        cnt++;

        return cnt <= days;
    }

}
