package day_110;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/18
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {31, 25, 18, 59};
        int x = 27;

        System.out.println(minCost(nums, x));
    }


    public long minCost(int[] nums, int x) {

        int len = nums.length;
        int[] f = new int[len];
        System.arraycopy(nums, 0, f, 0, len);
        long ans = getSum(nums);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                f[j] = Math.min(f[j], nums[(j + i) % len]);
            }

            ans = Math.min(ans, getSum(f) + (long) x * i);
        }

        return ans;
    }

    public long getSum(int[] nums) {
        long result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }

}
