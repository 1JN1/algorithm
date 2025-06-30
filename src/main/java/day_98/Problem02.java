package day_98;

/**
 * @author 王文涛
 * @date 2025/3/3
 * @description
 **/
public class Problem02 {



    public int specialArray(int[] nums) {

        int left = 0, right = nums.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // 判断数组中有多少个数大于等于mid
            int count = 0;
            for (int num : nums) {
                if (num >= mid) {
                    count++;
                }
            }

            if (count == mid) {
                return mid;
            } else if (count > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

}
