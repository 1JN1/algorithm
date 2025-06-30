package day_83;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem09 {

    @Test
    public void test() {
        int[] nums = {26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};

        System.out.println(countSmaller(nums));
    }


    int[] counts;

    public List<Integer> countSmaller(int[] nums) {


        int len = nums.length;

        if (len < 2) {
            return List.of(0);
        }

        this.counts = new int[len];

        int[][] copy = new int[len][2];
        for (int i = 0; i < len; i++) {
            copy[i][0] = nums[i];
            copy[i][1] = i;
        }

        int[][] temp = new int[len][2];

        mergeSort(copy, temp, 0, len - 1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res.add(counts[i]);
        }

        return res;
    }

    public void mergeSort(int[][] nums, int[][] temp, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;
            mergeSort(nums, temp, left, mid);
            mergeSort(nums, temp, mid + 1, right);
            merge(nums, temp, left, mid, right);
        }

    }

    public void merge(int[][] nums, int[][] temp, int left, int mid, int right) {

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left, j = mid + 1;

        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                nums[k] = temp[i++];
            } else if (temp[i][0] > temp[j][0]) {
                nums[k] = temp[i];
                int count = right - j + 1;
                counts[temp[i][1]] += count;
                i++;
            } else {
                nums[k] = temp[j++];
            }

        }

    }

}
