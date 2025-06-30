package day_04;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/9
 * @description 回文数
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(isPalindrome(121));

    }

    public boolean isPalindrome(int x) {

//        String xStr = String.valueOf(x);
//
//        int i = 0, j = xStr.length() - 1;
//
//        while (i < j) {
//            if (xStr.charAt(i++) != xStr.charAt(j--)) {
//                return false;
//            }
//        }
//
//        return true;


        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;

        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }


        return rev == x || rev / 10 == x;
    }

}
