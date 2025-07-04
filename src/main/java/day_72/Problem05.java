package day_72;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/1/18
 * @description
 **/
public class Problem05 {

    @Test
    public void test() {

    }

    public List<String> fizzBuzz(int n) {


        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }

        }

        return list;
    }

}
