package day_15;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/27
 * @description 外观数列
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(countAndSay(5));

    }


    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        String str = countAndSay(n - 1);

        return rle(str);
    }

    /**
     * 行程长度编码
     *
     * @param str
     * @return
     */
    public String rle(String str) {


        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (i < str.length()) {

            char c = str.charAt(i);

            int count = 1;

            // 连续字符的数目
            while ((i + count) < str.length() &&str.charAt(i + count) == c) {
                count++;
            }

            sb.append(count).append(c - '0');
            i += count;
        }

        return sb.toString();
    }

}
