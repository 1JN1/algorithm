package day_89;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/2/17
 * @description
 **/
public class Problem05 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // [right, arr.length - 1] >= x
        int right = binarySearch(arr, x);
        // [0, left] < x
        int left = right - 1;

        // 一共要找k个数
        while (k-- > 0) {

            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
                // 没有越界就每次选择距离x最接近的数
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }

        }

        List<Integer> ans = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }

    /**
     * 二分查找，找到第一个大于等于target的数
     *
     * @param arr
     * @param target
     * @return
     */
    public int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }

}
