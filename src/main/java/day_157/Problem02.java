package day_157;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 王文涛
 * @date 2025/6/10
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] arr = {6,7,11,7,6,8};
        int k = 5;
        System.out.println(Arrays.toString(getStrongest(arr, k)));
    }

    public int[] getStrongest(int[] arr, int k) {

        Arrays.sort(arr);

        int n = arr.length;
        // 求出中位数
        int num = arr[(n - 1) / 2];

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (Math.abs(a - num) == Math.abs(b - num)) {
                        return a - b;
                    }
                    return Math.abs(a - num) - Math.abs(b - num);
                }
        );

        for (int j : arr) {
            pq.offer(j);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.stream().mapToInt(i -> i).toArray();
    }

    public int[] getStrongest2(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n - 1) / 2];

        // 将原始数组转换为基于强度的比较
        int[] result = new int[k];
        int left = 0, right = n - 1;

        for (int i = 0; i < k; i++) {
            if (Math.abs(arr[right] - m) >= Math.abs(arr[left] - m)) {
                result[i] = arr[right--];
            } else {
                result[i] = arr[left++];
            }
        }

        return result;
    }

}
