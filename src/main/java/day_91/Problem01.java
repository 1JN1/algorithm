package day_91;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/20
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(reverseVowels("IceCreAm"));
    }

    public String reverseVowels(String s) {

        int left = 0, right = s.length() - 1;

        char[] chars = s.toCharArray();

        while (left < right) {

            while (left < right && !isVowel(chars[left])) {
                left++;
            }

            while (left < right && !isVowel(chars[right])) {
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
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
