package day_126;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/4/27
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] nums = {388589, 17165, 726687, 401298, 600033, 537254, 301052, 151069, 399955};
        int k = 4;

        System.out.println(goodIndices(nums, k));

    }

    public List<Integer> goodIndices(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (nums[n - i - 1] <= nums[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            }
        }

        for (int i = k; i < n - k; i++) {
            if (left[i - 1] >= k && right[i + 1] >= k) {
                res.add(i);
            }
        }

        return res;
    }

}
