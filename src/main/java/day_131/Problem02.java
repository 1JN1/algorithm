package day_131;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 王文涛
 * @date 2025/5/8
 * @description
 **/
public class Problem02 {

    public int reductionOperations(int[] nums) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            if (!map.containsKey(num)) {
                queue.offer(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (queue.size() > 1) {
            int max = queue.poll();
            count += map.get(max) * queue.size();
        }

        return count;
    }

    public int reductionOperations2(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                cnt++;
            }
            ans += cnt;
        }

        return ans;
    }
}
