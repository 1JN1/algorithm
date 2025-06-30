package day_82;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 王文涛
 * @date 2025/2/8
 * @description
 **/
public class Sort {


    @Test
    public void test() {

        int[] nums = {7, 3, 1, 2, 5, 9, 15, 10, 8, 6, 18};
        // bubbleSort(nums);
        // selectSort(nums);
        // insertSort(nums);
        // shellSort(nums);
        // mergeSort(nums, 0, nums.length - 1);
        // quickSort(nums);
        // heapSort(nums);
        // countingSort(nums);

        System.out.println(Arrays.toString(nums));

    }


    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {

        int len = nums.length;

        // 一共进行n-1次
        for (int i = 0; i < len - 1; i++) {

            // 本次冒泡是否发生元素交换
            boolean flag = false;

            for (int j = 0; j < len - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }

            }

            if (!flag) {
                break;
            }

        }

    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public void selectSort(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < len; j++) {

                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }

            }

            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }

        }

    }

    /**
     * 插入排序
     *
     * @param nums
     */
    public void insertSort(int[] nums) {

        int len = nums.length;

        for (int i = 1; i < len; i++) {

            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;

        }

    }

    /**
     * 希尔排序
     *
     * @param nums
     */
    public void shellSort(int[] nums) {

        int len = nums.length;
        // 分组间隔
        int gap = len / 2;

        while (gap > 0) {

            for (int i = gap; i < len; i++) {

                int temp = nums[i];
                int j = i;
                // 组内进行排序
                while (j >= gap && nums[j - gap] > temp) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp;
            }

            // 缩减间隔
            gap /= 2;
        }

    }

    /**
     * 归并排序
     *
     * @param nums
     * @param left
     * @param right
     */
    public void mergeSort(int[] nums, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

    }

    public void merge(int[] nums, int l, int m, int r) {

        int[] temp = Arrays.copyOfRange(nums, l, r + 1);
        int i = l, j = m + 1, k = l;

        while (i <= m && j <= r) {

            if (temp[i - l] < temp[j - l]) {
                nums[k++] = temp[i - l];
                i++;
            } else {
                nums[k++] = temp[j - l];
                j++;
            }

        }

        while (i <= m) {
            nums[k++] = temp[i - l];
            i++;
        }

        while (j <= r) {
            nums[k++] = temp[j - l];
            j++;
        }
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {

        if (left < right) {

            int idx = randomPartition(nums, left, right);
            quickSort(nums, left, idx - 1);
            quickSort(nums, idx + 1, right);

        }

    }

    public int randomPartition(int[] nums, int left, int right) {
        int idx = ThreadLocalRandom.current().nextInt(left, right + 1);

        int temp = nums[left];
        nums[left] = nums[idx];
        nums[idx] = temp;

        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {

        // 基准元素
        int pivot = nums[left];

        int i = left, j = right;

        while (i < j) {

            while (i < j && nums[j] >= pivot) {
                j--;
            }

            nums[i] = nums[j];

            while (i < j && nums[i] <= pivot) {
                i++;
            }

            nums[j] = nums[i];

        }

        nums[i] = pivot;

        return i;
    }

    /**
     * 堆排序
     *
     * @param nums
     */
    public void heapSort(int[] nums) {

        int n = nums.length;

        // 建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);

        }


    }

    /**
     * 调整堆
     * 将idx左右子树中较大的节点与idx交换，再递归的进行调整交换后的节点
     *
     * @param nums
     * @param n
     * @param idx
     */
    public void heapify(int[] nums, int n, int idx) {

        int largestIdx = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < n && nums[left] > nums[largestIdx]) {
            largestIdx = left;
        }

        if (right < n && nums[right] > nums[largestIdx]) {
            largestIdx = right;
        }

        if (largestIdx != idx) {

            int temp = nums[idx];
            nums[idx] = nums[largestIdx];
            nums[largestIdx] = temp;

            heapify(nums, n, largestIdx);
        }

    }

    /**
     * 计数排序
     *
     * @param nums
     */
    public void countingSort(int[] nums) {

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        int[] counting = new int[max - min + 1];

        int len = nums.length;

        // 生成计数数组
        for (int i = 0; i < len; i++) {
            counting[nums[i] - min]++;
        }

        // 生成累计数组
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        int[] temp = Arrays.copyOf(nums, len);

        // 根据累计数组反向填充待排序数组
        for (int i = 0; i < len; i++) {
            int num = temp[i];
            nums[counting[num - min] - 1] = num;
            counting[num - min] -= 1;
        }


    }

}
