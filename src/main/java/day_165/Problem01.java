package day_165;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/29
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] nums = {15,45,20,2,34,35,5,44,32,30};
        System.out.println(xorBeauty(nums));
    }

    public int xorBeauty(int[] nums) {

        int ans = 0;

        // 遍历所有可能的三元组
        int n = nums.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    ans ^= ((nums[i] | nums[j]) & nums[k]);
                }
            }
        }

        return ans;
    }

    public int xorBeauty2(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }

}
