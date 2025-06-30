package day_147;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/5/26
 * @description
 **/
public class Problem02 {

    public List<Long> minOperations(int[] nums, int[] queries) {


        List<Long> res = new ArrayList<>();

        for (int query : queries) {
            long sum = 0;
            for (int num : nums) {
                sum += Math.abs(num - query);
            }
            res.add(sum);
        }

        return res;
    }

    public List<Long> minOperations2(int[] nums, int[] queries) {

        int n = nums.length;
        Arrays.sort(nums);
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        List<Long> res = new ArrayList<>();
        for (int query : queries) {
            int i = Arrays.binarySearch(nums, query);
            if (i < 0) {
                i = -i - 1;
            }
            long left = (long) query * i - preSum[i];
            long right = preSum[n] - preSum[i] - (long) query * (n - i);

            res.add(left + right);
        }

        return res;
    }

}
