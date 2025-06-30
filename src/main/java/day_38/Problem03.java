package day_38;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/2
 * @description 乘积最大子数组
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3}));

    }

    public int maxProduct(int[] nums) {

        long max = nums[0], min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            long mx = max, mn = min;

            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));

            if (min < -1 << 31) {
                min = nums[i];
            }

            ans = Math.max(ans, (int) max);

        }

        return ans;
    }

}
