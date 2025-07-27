package day_177;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/27 11:12
 */
public class Problem05 {

    @Test
    public void test() {
        String s = "00111";
        System.out.println(maxOperations(s));
    }

    public int maxOperations(String s) {

        int oneNum = 0;
        int count = 0;

        char[] chars = s.toCharArray();

        int n = chars.length;
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == '1') {
                oneNum++;
            }
            if (chars[i] == '1' && chars[i + 1] == '0') {
                count += oneNum;
            }
        }

        return count;
    }

}
