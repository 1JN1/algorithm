package day_60;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/11/27
 * @description 两个数组的交集
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }

    public int[] intersection(int[] nums1, int[] nums2) {


        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();


        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {

            if (set.contains(num)) {
                ans.add(num);
            }

        }

        int[] res = new int[ans.size()];
        int i = 0;
        for (int an : ans) {
            res[i++] = an;
        }

        return res;
    }

}
