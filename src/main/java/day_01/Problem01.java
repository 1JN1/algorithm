package day_01;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/9/4
 * @description 两数之和
 **/
public class Problem01 {


    @Test
    public void test() {


        int[] arr = {2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum(arr, 9)));


    }


    /**
     * 使用哈希表解决
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                result[1] = map.get(target - nums[i]);
                result[0] = i;
            } else {
                map.put(nums[i], i);
            }

        }


        return result;
    }


}
