package day_149;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/5/28
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] nums = {1,2};
        System.out.println(thirdMax(nums));
    }

    public int thirdMax(int[] nums) {


        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int n = set.size();

        int max1 = set.stream().mapToInt(i -> i).max().getAsInt();
        if (n < 3){
            return max1;
        }

        int max2 = set.stream().filter(i -> i != max1).mapToInt(i -> i).max().getAsInt();
        int max3 = set.stream().filter(i -> i != max1 && i != max2).mapToInt(i -> i).max().getAsInt();

        return max3;
    }

    public int thirdMax2(int[] nums) {
        Integer a = null, b = null, c = null;
        for (int num : nums) {
            if (a == null || num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && (b == null || num > b)) {
                c = b;
                b = num;
            } else if (b != null && b > num && (c == null || num > c)) {
                c = num;
            }
        }
        return c == null ? a : c;
    }

}
