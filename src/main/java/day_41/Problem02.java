package day_41;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author 王文涛
 * @date 2024/11/6
 * @description 最大数
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] nums = {0, 0};

        System.out.println(largestNumber(nums));

    }


    public String largestNumber(int[] nums) {


        String[] strs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(
                strs,
                (x, y) -> (y + x).compareTo(x + y)
        );

        if ("0".equals(strs[0])) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        for (String str : strs) {
            builder.append(str);
        }

        return builder.toString();

    }

}
