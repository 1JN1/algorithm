package day_83;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem07 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        if (i == m - 1) {
            return;
        }

        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }

    }
}
