package day_177;

import org.junit.Test;

import java.util.Objects;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/27 9:20
 */
public class Problem02 {

    @Test
    public void test() {
        String text = "nufbkflwjjlwjjnufbkf";
        int result = longestDecomposition(text);
        System.out.println(result);
    }

    public int longestDecomposition(String text) {
        int left = 0, right = text.length() - 1;
        int count = 0;

        while (left <= right) {
            int len = 1;

            // 寻找匹配的前缀和后缀
            while (left + len - 1 < right - len + 1) {
                String leftSub = text.substring(left, left + len);
                String rightSub = text.substring(right - len + 1, right + 1);

                if (leftSub.equals(rightSub)) {
                    left += len;
                    right -= len;
                    count += 2;
                    len = 0;
                    break;
                }
                len++;
            }

            if (left + len - 1 >= right - len + 1) {
                count++;
                break;
            }
        }

        return count;
    }

}
