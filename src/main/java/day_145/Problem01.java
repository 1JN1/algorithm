package day_145;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/24
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] nums = new int[]{-1,2,-3,3};
        System.out.println(findMaxK(nums));
    }

    public int findMaxK(int[] nums) {

        int[] exists = new int[2001];
        int max = -1;

        int n = nums.length;

        for (int num : nums) {
            int temp = -num;
            if (exists[temp + 1000] == 1) {
                max = Math.max(max, Math.abs(temp));
            } else {
                exists[num + 1000] = 1;
            }
        }

        return max;
    }

}
