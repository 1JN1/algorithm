package day_167;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/7/1
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] nums = {4, 2, 4, 5, 6};
        System.out.println(maximumUniqueSubarray(nums));
    }

    public int maximumUniqueSubarray(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int max = 0;
        int n = nums.length;

        int idx = 0;

        while (idx < n) {
            int num = nums[idx];
            if (!map.containsKey(num)) {
                sum += num;
                map.put(num, idx);
                idx++;
            } else {
                max = Math.max(max, sum);
                int lastIdx = map.get(num);
                sum = 0;
                idx = lastIdx + 1;
                map.clear();
            }
        }

        max = Math.max(max, sum);
        return max;
    }

    public int maximumUniqueSubarray1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, sum = 0;
        int left = 0;

        for (int num : nums) {
            while (set.contains(num)) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(num);
            sum += num;
            max = Math.max(max, sum);
        }

        return max;
    }

}
