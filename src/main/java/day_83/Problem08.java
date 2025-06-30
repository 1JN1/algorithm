package day_83;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem08 {

    public int reversePairs(int[] record) {

        int len = record.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = record[i];
        }

        int[] temp = new int[len];


        return mergeSort(copy, temp, 0, len - 1);
    }

    public int mergeSort(int[] recode, int[] temp, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int ans = mergeSort(recode, temp, left, mid) + mergeSort(recode, temp, mid + 1, right);

        if (recode[mid] <= recode[mid + 1]) {
            return ans;
        }


        return merge(recode, temp, left, mid, right) + ans;
    }

    public int merge(int[] recode, int[] temp, int left, int mid, int right) {

        for (int i = left; i <= right; i++) {
            temp[i] = recode[i];
        }

        int i = left, j = mid + 1;
        int count = 0;

        for (int k = left; k <= right; k++) {

            // 左子区间已填充完
            if (i == mid + 1) {
                recode[k] = temp[j++];
            } else if (j == right + 1) {
                recode[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                recode[k] = temp[i++];
            } else {
                recode[k] = temp[j++];
                count += mid - i + 1;
            }

        }

        return count;
    }

}
