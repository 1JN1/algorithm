package day_40;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/5
 * @description 多数元素
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] nums = {6, 6, 6, 7, 7};

        System.out.println(majorityElement(nums));

    }

    public int majorityElement(int[] nums) {

        int ans = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == ans) {
                count++;
            } else {
                count--;

                if (count == 0) {
                    ans = nums[i];
                    count = 1;
                }


            }

        }

        return ans;
    }

}
