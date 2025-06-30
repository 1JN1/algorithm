package day_150;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/5/30
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] nums1 = {1, 28, 21};
        int[] nums2 = {9, 21, 20};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    private static final int MOD = 1_000_000_007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] sorted = nums1.clone();
        // 排序以便二分查找
        Arrays.sort(sorted);

        // 使用 long 防止溢出
        long total = 0;
        int maxReduction = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            total += diff;

            // 找到 nums1 中最接近 nums2[i] 的元素
            int closest = findClosest(sorted, nums2[i]);
            int newDiff = Math.abs(closest - nums2[i]);
            maxReduction = Math.max(maxReduction, diff - newDiff);
        }

        long result = (total - maxReduction) % MOD;
        return (int) result;
    }

    /**
     * 在已排序数组中找到最接近 target 的元素
     *
     * @param sorted
     * @param target
     * @return
     */
    private int findClosest(int[] sorted, int target) {
        int left = 0, right = sorted.length - 1;
        int closest = sorted[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            closest = getCloser(closest, sorted[mid], target);
            if (sorted[mid] < target) {
                left = mid + 1;
            } else if (sorted[mid] > target) {
                right = mid - 1;
            } else {
                // 直接找到相等的元素
                return target;
            }
        }
        return closest;
    }

    /**
     * 返回更接近 target 的值
     *
     * @param a
     * @param b
     * @param target
     * @return
     */
    private int getCloser(int a, int b, int target) {
        if (Math.abs(a - target) < Math.abs(b - target)) {
            return a;
        } else {
            return b;
        }
    }

}
