package day_49;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 只出现一次的数字
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));

    }

    public int[] singleNumber(int[] nums) {

        int pivot = 0;

        for (int num : nums) {
            pivot ^= num;
        }

        // 找出pivot最低位的1
        int i = 0;
        while ((pivot & (1 << i)) == 0) {
            i++;
        }

        int[] result = new int[2];

        int num1 = 0;
        for (int num : nums) {

            if ((num & (1 << i)) != 0) {
                num1 ^= num;
            }

        }

        result[0] = num1;
        result[1] = pivot ^ num1;

        return result;
    }

}
