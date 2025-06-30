package day_114;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/3/23
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {5, 4, 0, 3, 1, 6, 2};

        System.out.println(arrayNesting(nums));

    }

    public int arrayNesting(int[] nums) {

        int len = nums.length;

        boolean[] vis = new boolean[len];

        int max = 0;
        for (int i = 0; i < len; i++) {

            if (vis[i]) {
                continue;
            }

            vis[i] = true;
            int curIdx = nums[i];
            int curLen = 1;

            while (curIdx != i) {

                vis[curIdx] = true;
                curLen++;
                curIdx = nums[curIdx];
            }

            max = Math.max(max, curLen);

            if (max > len / 2) {
                return max;
            }

        }

        return max;
    }

}
