package day_159;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/16
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        String word = "aaaaab";
        System.out.println(addMinimum(word));
    }

    public int addMinimum(String word) {

        int count = 0;

        char[] chars = word.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n) {
            char ch = chars[idx];
            if (ch == 'a') {
                // 是最后一个字符
                if (idx == n - 1) {
                    count += 2;
                    idx++;
                } else if (chars[idx + 1] != 'b') {
                    if (chars[idx + 1] != 'c') {
                        count += 2;
                        idx += 1;
                    } else {
                        count += 1;
                        idx += 2;
                    }
                } else {
                    idx++;
                }
            } else if (ch == 'b') {
                if (idx == 0 || chars[idx - 1] != 'a') {
                    count += 1;
                }

                if (idx == n - 1 || chars[idx + 1] != 'c') {
                    count += 1;
                }

                idx++;

            } else if (ch == 'c') {
                if (idx == 0 || chars[idx - 1] != 'b') {
                    count += 2;
                }
                idx++;
            }
        }

        return count;
    }

}
