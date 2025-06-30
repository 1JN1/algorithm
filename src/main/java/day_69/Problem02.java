package day_69;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/1/14
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {


        System.out.println(firstUniqChar("loveleetcode"));

    }

    public int firstUniqChar(String s) {


        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {

            counts[s.charAt(i) - 'a']++;

        }


        for (int i = 0; i < s.length(); i++) {

            if (counts[s.charAt(i) - 'a'] == 1) {
                return i;
            }

        }


        return -1;
    }


}
