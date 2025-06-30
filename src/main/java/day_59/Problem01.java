package day_59;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/26
 * @description 反转字符串中的元音字母
 **/
public class Problem01 {

    @Test
    public void test() {


        String s = "IceCreAm";

        s = reverseVowels(s);

        System.out.println(s);
    }

    public String reverseVowels(String s) {

        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {

            // 找到左边的第一个元音字母
            while (left < right && !isVowel(Character.toLowerCase(chars[left]))) {
                left++;
            }

            // 找到右边的第一个元音字母
            while (left < right && !isVowel(Character.toLowerCase(chars[right]))) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;


        }

        return new String(chars);
    }

    public boolean isVowel(char c) {

        switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> {
                return true;
            }
            default -> {
                return false;
            }
        }

    }

}
