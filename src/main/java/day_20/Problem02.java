package day_20;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/4
 * @description 最大子数组和
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }


    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
