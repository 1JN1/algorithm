package day_90;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 王文涛
 * @date 2025/2/18
 * @description
 **/
public class Problem01 {

    /**
     * 空间复杂度过高
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {

        int n = nums.length;
        int len = n * (n - 1) / 2;
        // 统计出所有的数对之差
        int[] diff = new int[len];
        int index = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                diff[index++] = Math.abs(nums[i] - nums[j]);
            }

        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < len; i++) {
            pq.add(diff[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        return pq.peek();
    }

    public int smallestDistancePair1(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {

            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0, j = 0; j < n; j++) {

                while (i < j && nums[j] - nums[i] > mid) {
                    i++;
                }

                count += j - i;
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }

}
