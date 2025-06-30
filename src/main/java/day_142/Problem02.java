package day_142;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/5/20
 * @description
 **/
public class Problem02 {

    public int countQuadruplets(int[] nums) {

        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public int countQuadruplets2(int[] nums) {

        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int b = n - 3; b >= 0; b--) {

            for (int d = b + 2; d < n; d++) {
                map.put(nums[d] - nums[b + 1], map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }

            for (int a = 0; a < b; a++){
                count += map.getOrDefault(nums[a] + nums[b], 0);
            }

        }

        return count;
    }
}
