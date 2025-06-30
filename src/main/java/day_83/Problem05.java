package day_83;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem05 {
    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {

        if (left < right) {

            int partition = randomPartition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);

        }

    }

    public int randomPartition(int[] nums, int left, int right) {

        int idx = ThreadLocalRandom.current().nextInt(left, right + 1);
        swap(nums, idx, left);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {

        int pivot = nums[left];

        while (left < right) {

            while (left < right && nums[right] >= pivot) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            nums[right] = nums[left];

        }

        nums[left] = pivot;

        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
