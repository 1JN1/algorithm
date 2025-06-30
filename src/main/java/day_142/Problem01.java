package day_142;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/20
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] nums = {2,1,4,5,3,1,1,3};
        System.out.println(massage(nums));
    }

    public int massage(int[] nums) {

        int n = nums.length;

        if (n == 0){
            return 0;
        }

        int pre = 0, cur = nums[0];

        for (int i = 1; i < n; i++){
            int temp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = temp;
        }

        return cur;
    }
}
