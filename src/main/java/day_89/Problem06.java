package day_89;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/2/17
 * @description
 **/
public class Problem06 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {

            if (set1.contains(num)) {
                set2.add(num);
            }

        }


        int[] ans = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            ans[i++] = num;
        }

        return ans;
    }

}
