package day_33;

import org.junit.Test;


/**
 * @author 王文涛
 * @date 2024/10/21
 * @description
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(isPalindrome(".,.,.,.,"));

    }

    public boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;

        while (i < j) {

            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i >= j) {
                break;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;

        }

        return true;
    }

}
