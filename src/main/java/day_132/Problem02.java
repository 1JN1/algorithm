package day_132;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/9
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] arr = {2, 1, 2, 2, 2};
        int target = 1;
        System.out.println(search(arr, target));
    }

    public int search(int[] arr, int target) {

        int n = arr.length;
        int left = 0, right = n - 1;

        if (arr[0] == target) {
            return 0;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                while (mid > 0 && arr[mid] == arr[mid - 1]) {
                    mid--;
                }
                return mid;
            }

            if (arr[mid] == arr[left] && arr[mid] == arr[right]){
                left++;
                right--;
            }else if (arr[left] <= arr[mid]){
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else{
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
