package day_123;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/4/21
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] nums = {};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        int n = nums.length;

        int[] preSum = new int[n + 1];

        preSum[0] = 0;

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = (i == 0 ? 0 : preSum[i]) + nums[i];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = i + 2; j <= n; j++) {
                if ((preSum[j] - preSum[i]) == 0) {
                    return true;
                }
                if (k != 0 && (preSum[j] - preSum[i]) % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {

        int n = nums.length;

        if (n < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>(n + 1);
        map.put(0, -1);
        int remainder = 0;

        for (int i = 0; i < n; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                Integer preIdx = map.get(remainder);
                if (i - preIdx >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }

}
