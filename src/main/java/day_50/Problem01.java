package day_50;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description 丢失的数字
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(missingNumber(new int[]{3, 0, 1}));

    }

    public int missingNumber(int[] nums) {

        int n = nums.length;

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans ^= i;
        }

        for (int i = 0; i < n; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

}
