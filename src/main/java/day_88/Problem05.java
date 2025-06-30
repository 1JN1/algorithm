package day_88;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/15
 * @description
 **/
public class Problem05 {

    @Test
    public void test() {

        int[] arr = {2, 3, 5};
        int target = 11;

        System.out.println(findBestValue(arr, target));

    }

    public int findBestValue(int[] arr, int target) {

        int max = Arrays.stream(arr).max().getAsInt();
        int left = 1, right = max;
        int ans = 0, sum = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] > mid) {
                    temp += mid;
                } else {
                    temp += arr[i];
                }

            }

            if (Math.abs(temp - target) < Math.abs(sum - target)) {
                sum = temp;
                ans = mid;
            }

            if (temp > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return ans;
    }

}
