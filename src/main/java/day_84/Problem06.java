package day_84;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/10
 * @description
 **/
public class Problem06 {

    public String largestNumber(int[] nums) {

        int n = nums.length;

        String[] numStrs = new String[n];

        for (int i = 0; i < n; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        StringBuilder sb = new StringBuilder();

        if (numStrs[0].equals("0")) {
            return "0";
        }

        for (int i = 0; i < n; i++) {
            sb.append(numStrs[i]);
        }

        return sb.toString();
    }

}
