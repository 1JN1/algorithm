package day_135;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/12
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {0, 3, 2, 1, 3, 2};
        int[] ans = getSneakyNumbers(nums);
        System.out.println(ans[0] + " " + ans[1]);

        ans = getSneakyNumbers2(nums);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public int[] getSneakyNumbers(int[] nums) {

        int[] count = new int[100];
        int[] ans = new int[2];
        int idx = 0;

        for (int num : nums) {
            count[num]++;

            if (count[num] == 2) {
                ans[idx++] = num;
            }

        }

        return ans;
    }

    public int[] getSneakyNumbers2(int[] nums) {

        int n = nums.length - 2;
        int xorAll = n ^ (n + 1);

        // 人为的将nums中所有的其他数变为偶数次，要求的数变为奇数次，这样最后异或的结果就是两个目标值的异或
        for (int i = 0; i < nums.length; i++) {
            xorAll ^= i ^ nums[i];
        }

        // 二进制最低位1所在位，用来区分两个数
        int shift = Integer.numberOfTrailingZeros(xorAll);

        int[] ans = new int[2];
        // 分组异或，第shift位一样的异或在一起
        for (int i = 0; i < nums.length; i++) {
            // 下面的这种方式，会让不需要求的数出现偶数次，需要求的数出现奇数次
            // 应该存在的数
            if (i < n) {
                ans[i >> shift & 1] ^= i;
            }
            // 实际存在的数
            ans[nums[i] >> shift & 1] ^= nums[i];
        }

        return ans;
    }
}
