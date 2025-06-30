package day_79;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/2/1
 * @description
 **/
public class Problem01 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {


        Map<Integer, Integer> map = new HashMap<>();

        int n1 = nums1.length, n2 = nums2.length, n3 = nums3.length, n4 = nums4.length;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int num = nums1[i] + nums2[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n3; i++) {
            for (int j = 0; j < n4; j++) {
                int num = nums3[i] + nums4[j];
                if (map.containsKey(-num)) {
                    count += map.get(-num);
                }
            }
        }

        return count;
    }

}
