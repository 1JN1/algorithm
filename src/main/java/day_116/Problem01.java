package day_116;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/3/25
 * @description
 **/
public class Problem01 {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>(nums.length);

        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int s : set) {

            if (!set.contains(s - 1)) {

                int curNum = s;
                int curLen = 1;

                while (set.contains(curNum + 1)) {
                    curLen++;
                    curNum++;
                }

                maxLen = Math.max(maxLen, curLen);
            }

        }

        return maxLen;
    }

}
