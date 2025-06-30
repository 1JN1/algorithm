package day_06;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/11
 * @description 最长公共前缀
 **/
public class Problem01 {


    @Test
    public void test() {

        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        int n = strs.length;

        int length = strs[0].length();

        for (int i = 0; i < length; i++) {

            char c = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }

        }

        return strs[0];
    }

}
