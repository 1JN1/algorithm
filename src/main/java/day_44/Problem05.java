package day_44;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/9
 * @description 数组中的第K个最大元素
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3));

    }

    public int findKthLargest(int[] nums, int k) {

        // 建堆
        buildHeap(nums, nums.length);

        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {

            swap(nums, i, 0);
            heapAdjust(nums, 0, i);

        }

        return nums[0];
    }

    private void buildHeap(int[] nums, int heapSize) {

        for (int i = heapSize / 2 - 1; i >= 0; i--) {

            heapAdjust(nums, i, heapSize);
        }

    }

    private void heapAdjust(int[] nums, int idx, int heapSize) {

        while (idx < heapSize) {
            int left = idx * 2 + 1, right = idx * 2 + 2, maxIdx = idx;

            if (left < heapSize && nums[left] > nums[maxIdx]) {
                maxIdx = left;
            }

            if (right < heapSize && nums[right] > nums[maxIdx]) {
                maxIdx = right;
            }

            if (maxIdx != idx) {

                swap(nums, idx, maxIdx);

                idx = maxIdx;

            } else {
                break;
            }
        }

    }

    private void swap(int[] nums, int idx, int maxIdx) {

        int temp = nums[idx];
        nums[idx] = nums[maxIdx];
        nums[maxIdx] = temp;

    }

}
