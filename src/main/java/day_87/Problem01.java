package day_87;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/14
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] arr = {3, 4, 5, 1};

        System.out.println(peakIndexInMountainArray(arr));

    }

    public int peakIndexInMountainArray(int[] arr) {

        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid == 0) {
                left = mid + 1;
            } else if (mid == n - 1) {
                right = mid - 1;
            } else {

                // 上坡
                if (arr[mid] <= arr[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }

        return left;
    }

}
