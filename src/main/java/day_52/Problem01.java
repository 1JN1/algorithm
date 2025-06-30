package day_52;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2024/11/17
 * @description 单词的唯一缩写
 **/
public class Problem01 {

    @Test
    public void test() {

        String[] dictionary = {
                "deer", "door", "cake", "card"
        };

        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dictionary);

        System.out.println(validWordAbbr.isUnique("dear")); // false
        System.out.println(validWordAbbr.isUnique("door"));
        System.out.println(validWordAbbr.isUnique("cake"));
        System.out.println(validWordAbbr.isUnique("card"));

        System.out.println(validWordAbbr.isUnique("old"));

    }

    class ValidWordAbbr {

        private Map<String, Set<String>> map = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {

            for (String str : dictionary) {

                map.computeIfAbsent(abbr(str), k -> new HashSet<>()).add(str);

            }

        }

        public boolean isUnique(String word) {


            word = abbr(word);

            return map.get(word) == null || map.get(word).size() == 1;
        }

        private String abbr(String word) {

            return word.length() <= 2 ? word : word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
        }
    }

}
