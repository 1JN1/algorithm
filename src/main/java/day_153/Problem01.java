package day_153;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/2
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] nums = {37, 1, 2, 9, 5, 8, 5, 2, 9, 4};
        System.out.println(missingInteger(nums));
    }

    public int missingInteger(int[] nums) {

        int ans = 0;
        boolean[] flag = new boolean[51];
        int n = nums.length;

        if (n == 0) {
            return nums[0] + 1;
        }

        for (int num : nums) {
            flag[num] = true;
        }

        // 找出最长顺序前缀和
        int idx = 1;

        while (idx < n && nums[idx] == nums[idx - 1] + 1) {
            idx++;
        }

        int finalSum = (nums[0] + nums[idx - 1]) * idx / 2;

        // 找出大于finalSum的最小整数
        while (true) {
            if (finalSum > 50 || !flag[finalSum]) {
                ans = finalSum;
                break;
            }
            finalSum++;
        }

        return ans;
    }
}
