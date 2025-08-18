package day_185;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/18 9:20
 */
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};

        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }

    public int[] createTargetArray(int[] nums, int[] index) {

        int len = nums.length;
        int[] ans = new int[len];

        Arrays.fill(ans, -1);

        for (int i = 0; i < len; i++) {
            int idx = index[i];
            int num = nums[i];

            if (ans[idx] == -1) {
                ans[idx] = num;
                continue;
            }

            insert(ans, idx, num);
        }

        return ans;
    }

    private void insert(int[] nums, int idx, int num) {

        int len = nums.length;

        for (int i = len - 1; i > idx; i--) {
            nums[i] = nums[i - 1];
        }

        nums[idx] = num;
    }
}
