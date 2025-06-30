package day_139;

import org.junit.Test;

import java.util.List;

/**
 * @author 王文涛
 * @date 2025/5/16
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        List<Integer> nums = List.of(1, 1, 1, 2, 5, 7);
        System.out.println(sumIndicesWithKSetBits(nums, 2));
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int res = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++){
            if (Integer.bitCount(i) == k){
                res += nums.get(i);
            }
        }

        return res;
    }

}
