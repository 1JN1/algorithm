package day_92;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/21
 * @description
 **/
public class Problem04 {

    @Test
    public void test() {

        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

        int k = compress(chars);

        for (int i = 0; i < k; i++) {
            System.out.print(chars[i]);
        }

    }

    public int compress(char[] chars) {

        int n = chars.length;
        int k = 0;
        int left = 0, right = 0;

        while (right < n) {

            int count = 0;
            while (right < n && chars[right] == chars[left]) {
                count++;
                right++;
            }

            if (count == 1) {
                chars[k++] = chars[left];
            } else {
                chars[k++] = chars[left];
                if (count < 10) {
                    chars[k++] = (char) (count + '0');
                } else {
                    // 统计数字的位数
                    int len = 0;
                    int temp = count;
                    while (temp != 0) {
                        len++;
                        temp /= 10;
                    }
                    for (int i = len - 1; i >= 0; i--) {
                        int num = count / (int) Math.pow(10, i);
                        chars[k++] = (char) (num % 10 + '0');
                    }
                }
            }

            left = right;
        }

        return k;
    }

}
