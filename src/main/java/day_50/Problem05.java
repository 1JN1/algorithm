package day_50;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description 移动零
 **/
public class Problem05 {

    @Test
    public void test() {

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));

    }

    public void moveZeroes(int[] nums) {

        // 移动非0向前
        int k = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // 填充0
        for (int i = k; i < n; i++) {
            nums[i] = 0;
        }

    }

}
