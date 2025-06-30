package day_45;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/10
 * @description 存在重复元素
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(containsDuplicate(new int[]{1, 3, 2, 1}));

    }

    public boolean containsDuplicate(int[] nums) {


        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }

        return false;
    }

}
