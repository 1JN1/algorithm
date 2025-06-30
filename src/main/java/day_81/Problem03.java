package day_81;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/5
 * @description 寻找数组的中心下标
 **/
public class Problem03 {


    @Test
    public void test() {

        int[] nums = {2, 1, -1};

        System.out.println(pivotIndex(nums));

    }

    public int pivotIndex(int[] nums) {

        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum * 2 == sum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

}
