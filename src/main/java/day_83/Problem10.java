package day_83;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem10 {

    public int majorityElement(int[] nums) {

        int ans = nums[0];
        int count = 1;

        int len = nums.length;
        for (int i = 1; i < len; i++) {

            if (count == 0) {
                ans = nums[i];
                count = 1;
                continue;
            }

            if (nums[i] == ans) {
                count++;
            } else {
                count--;
            }

        }

        return ans;
    }

}
