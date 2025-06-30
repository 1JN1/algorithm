package day_163;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/6/27
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }

    public int numJewelsInStones(String jewels, String stones) {

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : jewels.toCharArray()){
            map.put(c, 0);
        }

        for (Character c : stones.toCharArray()){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
        }

        int sum = 0;
        for (Integer i : map.values()){
            sum += i;
        }

        return sum;
    }

}
