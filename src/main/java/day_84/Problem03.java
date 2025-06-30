package day_84;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/2/10
 * @description
 **/
public class Problem03 {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}
