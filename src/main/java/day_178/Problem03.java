package day_178;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/29 10:18
 */
public class Problem03 {

    @Test
    public void test() {

        int[] nums = {105, 11};

        System.out.println(minOperations(nums));

    }

    private static final int MX = 1_000_001;
    private static final int[] lpf = new int[MX];

    static {
        for (int i = 2; i < MX; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j < MX; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }
    }

    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                nums[i] = lpf[nums[i]];
                if (nums[i] > nums[i + 1]) {
                    return -1;
                }
                ans++;
            }
        }
        return ans;
    }
}
