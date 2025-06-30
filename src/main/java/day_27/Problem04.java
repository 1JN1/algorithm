package day_27;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/10/13
 * @description 合并两个有序数组
 **/
public class Problem04 {

    @Test
    public void test() {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int i = 0, j = 0, k = 0;

        int[] temp = new int[m + n];

        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }

        }

        while (i < m) {
            temp[k++] = nums1[i++];
        }

        while (j < n) {
            temp[k++] = nums2[j++];
        }

        System.arraycopy(temp, 0, nums1, 0, m + n);

    }

    /**
     * 倒着填，可以不需要辅助数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {


        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }

        }

        if (k >= 0 && i == m - 1) {
            return;
        }

        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }

}
