package day_34;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2024/10/23
 * @description 最长连续序列
 **/
public class Problem01 {

    @Test
    public void test() {


        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutive(nums));

    }

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (Integer s : set) {

            if (!set.contains(s - 1)) {

                int currentNum = s;
                int currentLen = 1;

                while (set.contains(currentNum + 1)) {
                    currentLen++;
                    currentNum++;
                }

                maxLen = Math.max(maxLen, currentLen);
            }

        }


        return maxLen;
    }

}
