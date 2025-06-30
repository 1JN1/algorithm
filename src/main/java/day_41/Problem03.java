package day_41;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/6
 * @description 轮转数组
 **/
public class Problem03 {

    @Test
    public void test() {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        rotate(nums, 3);

        System.out.println(Arrays.toString(nums));

    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;

        k = k % n;

        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);

    }

    public void reverse(int[] nums, int begin, int end) {

        int len = end - begin + 1;

        for (int i = 0; i < len / 2; i++) {
            int temp = nums[begin + i];
            nums[begin + i] = nums[end - i];
            nums[end - i] = temp;
        }

    }

}
