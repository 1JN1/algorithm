package day_47;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/12
 * @description 除自身以外数组的乘积
 **/
public class Problem05 {

    @Test
    public void test() {

        int[] nums = {0, 0};

        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];

        // 除了0以外的乘积
        int totalNoZero = 1;
        // 数组中是否含有0
        boolean containZero = false;
        // 数组中含有的0的数目
        int zeroNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                containZero = true;
                continue;
            }
            totalNoZero *= nums[i];
        }

        if (zeroNum > 1) {
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if (containZero) {

                if (nums[i] == 0) {
                    ans[i] = totalNoZero;
                } else {
                    ans[i] = 0;
                }

            } else {
                ans[i] = totalNoZero / nums[i];
            }
        }


        return ans;
    }

}
