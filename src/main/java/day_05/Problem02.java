package day_05;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/9/10
 * @description 罗马数字转成数字
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(romanToInt("MCMXCIV"));

    }

    public int romanToInt(String s) {


        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int n = s.length();

        int result = 0;

        for (int i = 0; i < n; i++) {

            int value = symbolValues.get(s.charAt(i));

            if(i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                result -= value;
            }else{
                result += value;
            }

        }

        return result;
    }

}
