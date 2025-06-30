package day_73;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/1/19
 * @description 数组中两个数的最大异或值
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(31 - Integer.numberOfLeadingZeros(8));

    }

    public int findMaximumXOR(int[] nums) {

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // 最大值二进制的次高位
        int n = 31 - Integer.numberOfLeadingZeros(max);

        Set<Integer> set = new HashSet<>();
        int ans = 0, mask = 0;
        for (int i = n; i >= 0; i--) {

            set.clear();
            mask |= (1 << i);
            int newAns = ans | (1 << i);

            for (int num : nums) {

                int x = num & mask;

                if (set.contains(newAns ^ x)) {
                    ans = newAns;
                    break;
                }
                set.add(x);

            }

        }

        return ans;
    }
}
