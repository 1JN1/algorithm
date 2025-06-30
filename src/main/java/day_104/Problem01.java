package day_104;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/3/11
 * @description
 **/
public class Problem01 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> ans = new ArrayList<>();
        int len = l.length;

        for (int i = 0; i < len; i++) {

            int left = l[i], right = r[i];
            int max = nums[left], min = nums[left];
            // 求出首项和末项
            for (int j = left; j <= right; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
            }

            // 所有元素相同，是等差数列
            if (max == min) {
                ans.add(true);
                continue;
            }

            // 不能整除
            if ((max - min) % (right - left) != 0) {
                ans.add(false);
                continue;
            }

            // 求出公差
            int d = (max - min) / (right - left);
            boolean flag = true;
            boolean[] seen = new boolean[right - left + 1];
            for (int j = left; j <= right; j++) {

                // 不是首项的公差倍
                if ((nums[j] - min) % d != 0) {
                    flag = false;
                    break;
                }

                // 求出该数在等差数列中的位置
                int index = (nums[j] - min) / d;
                // 这个数已经出现过了
                if (seen[index]) {
                    flag = false;
                    break;
                }
                seen[index] = true;

            }
            ans.add(flag);

        }

        return ans;
    }

}
