package day_55;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/20
 * @description 最大单词长度乘积
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));

    }

    public int maxProduct(String[] words) {


        Map<Integer, Integer> map = new HashMap<>();
        int n = words.length;
        int result = 0;

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int mask = 0;

            for (int i1 = 0; i1 < word.length(); i1++) {
                mask |= 1 << (word.charAt(i1) - 'a');
            }

            if (word.length() > map.getOrDefault(mask, 0)) {
                map.put(mask, word.length());
            }

        }

        for (Integer mask : map.keySet()) {

            int length1 = map.get(mask);

            for (Integer mask2 : map.keySet()) {

                if ((mask & mask2) == 0){

                    int length2 = map.get(mask2);

                    result = Math.max(result, length1 * length2);

                }

            }

        }

        return result;
    }

}



