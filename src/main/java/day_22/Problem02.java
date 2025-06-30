package day_22;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/6
 * @description 最后一个单词的长度
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(lengthOfLastWord("luffy is still joyboy"));

    }

    public int lengthOfLastWord(String s) {

//        // 去掉前后多余的空格
//        s = s.trim();
//
//        String[] strings = s.split(" ");
//
//        return strings[strings.length - 1].length();

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int count = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }

}
