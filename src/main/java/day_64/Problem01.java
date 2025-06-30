package day_64;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/12/1
 * @description 区间加法
 **/
public class Problem01 {

    @Test
    public void test() {

        int length = 5;

        int[][] updates = {
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };

        System.out.println(Arrays.toString(getModifiedArray(length, updates)));

    }

    /**
     * 差分数组模版题
     *
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {


        int[] nums = new int[length];

        for (int[] update : updates) {
            int l = update[0], r = update[1], val = update[2];
            nums[l] += val;
            if (r + 1 < length) {
                nums[r + 1] -= val;
            }
        }

        for (int i = 1; i < length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

}
