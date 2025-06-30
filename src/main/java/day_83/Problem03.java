package day_83;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem03 {

    public int findKthLargest(int[] nums, int k) {

        // 建堆
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }

        for (int i = n - 1; i > n - k; i--) {

            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            heapify(nums, 0, i);

        }

        return nums[0];
    }

    public void heapify(int[] nums, int k, int n) {

        int largest = k;
        int left = 2 * k + 1, right = 2 * k + 2;

        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != k) {
            int temp = nums[k];
            nums[k] = nums[largest];
            nums[largest] = temp;
            heapify(nums, largest, n);
        }
    }

}
