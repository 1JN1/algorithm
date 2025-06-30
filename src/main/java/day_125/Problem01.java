package day_125;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 王文涛
 * @date 2025/4/26
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";

        System.out.println(areNumbersAscending(s));

    }

    public boolean areNumbersAscending(String s) {

        String[] strings = s.split(" ");

//        List<Integer> collect = Arrays.stream(strings)
//                .filter(str -> str.matches("\\d+"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        for (int i = 0; i < collect.size() - 1; i++) {
//            if (collect.get(i) >= collect.get(i + 1)) {
//                return false;
//            }
//        }

        int preV = -1;

        for (String token : strings) {

            if (token.matches("\\d+")){
                int v = Integer.parseInt(token);
                if (preV >= v) {
                    return false;
                }
                preV = v;
            }

        }

        return true;
    }

}
