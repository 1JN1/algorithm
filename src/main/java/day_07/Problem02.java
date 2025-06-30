package day_07;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/9/12
 * @description 电话号码的字母组合
 **/
public class Problem02 {


    @Test
    public void test() {

        System.out.println(letterCombinations("234"));

    }


    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>(digits.length());
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));


        String[] strings = digits.split("");

        for (String str : strings) {

            List<String> list = map.get(str);

            List<String> temp = new ArrayList<>(res);

            int len = list.size();

            if (!temp.isEmpty()) {
                for (String re : temp) {
                    for (int i = 0; i < len; i++) {
                        if(res.contains(re)){
                            res.remove(re);
                        }
                        res.add(re + list.get(i));
                    }
                }
            } else {
                res.addAll(list);
            }

        }

        return res;
    }

}
