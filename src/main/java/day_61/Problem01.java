package day_61;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 王文涛
 * @date 2024/11/28
 * @description 两个数组的交集II
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));

    }

    public int[] intersect(int[] nums1, int[] nums2) {


        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }


        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}
