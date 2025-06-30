package day_60;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/11/27
 * @description 前k个高频元素
 **/
public class Problem01 {

    @Test
    public void test() {

        //System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));

        int[] nums = {4, 5, 7, 6, 8, 9, 1, 2, 3, 10086};

        heapSort(nums);

        System.out.println(Arrays.toString(nums));

    }

    public int[] topKFrequent(int[] nums, int k) {

        // 统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> map.get(o2) - map.get(o1)
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry.getKey());
        }

        int[] ans = new int[k];

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            ans[i] = queue.poll();
        }

        return ans;
    }


    private void buildHeap(int[] nums, int len) {

        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, len);
        }

    }

    private void adjustHeap(int[] nums, int k, int len) {

        int idx = k * 2 + 1;

        if (idx >= len) {
            return;
        }

        if (idx + 1 < len && nums[idx] < nums[idx + 1]) {
            idx++;
        }

        if (nums[idx] > nums[k]) {

            int temp = nums[idx];
            nums[idx] = nums[k];
            nums[k] = temp;

            adjustHeap(nums, idx, len);
        }

    }

    private void heapSort(int[] nums) {

        int len = nums.length;

        // 建堆
        buildHeap(nums, len);

        for (int i = len - 1; i >= 0; i--) {

            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            adjustHeap(nums, 0, i);

        }

    }

}
