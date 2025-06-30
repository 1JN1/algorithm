package day_83;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem13 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {


        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            Long num = set.ceiling((long) nums[i] - (long) valueDiff);

            if (num != null && num <= (long) nums[i] + (long) valueDiff) {
                return true;
            }

            set.add((long) nums[i]);

            if (i >= indexDiff) {
                set.remove((long) (nums[i - indexDiff]));
            }

        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {

        Map<Long, Long> map = new HashMap<>();
        long w = valueDiff + 1L;

        for (int i = 0; i < nums.length; i++) {

            long id = getId(nums[i], w);

            if (map.containsKey(id)) {
                return true;
            }

            if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) < w) {
                return true;
            }

            if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) < w) {
                return true;
            }

            map.put(id, (long) nums[i]);

            if (i >= indexDiff) {
                map.remove(getId(nums[i - indexDiff], w));
            }

        }

        return false;
    }

    public long getId(long x, long w) {

        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }

}
