package day_84;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/10
 * @description
 **/
public class Problem02 {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;

        int n = nums.length;
        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
        }

        return sum;
    }


}
