package day_76;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/23
 * @description 压缩字符串
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(compress(new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'}));

    }

    public int compress(char[] chars) {

        int left = 0, right = 0;
        int size = 0;

        int n = chars.length;

        while (right < n) {

            int count = 0;

            while (right < n && chars[right] == chars[left]) {
                count++;
                right++;
            }

            chars[size++] = chars[left];

            if (count >= 10) {

                // 求出count的位数
                int len = 0;
                int num = count;
                while (num != 0) {
                    len++;
                    num /= 10;
                }

                for (int i = len - 1; i >= 0; i--) {
                    num = (int) (count / Math.pow(10, i));
                    chars[size++] = (char) (num + '0');
                    count -= (int) Math.pow(10, i) * num;

                }

            } else if (count > 1) {
                chars[size++] = (char) (count + '0');
            }

            left = right;

        }

        return size;
    }

}
