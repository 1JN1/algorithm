package day_40;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/5
 * @description 两数之和III-数据结构的设计
 **/
public class Problem03 {

    class TwoSum {

        Map<Integer, Integer> map = new HashMap<>();

        private static final int MAX_LEN = 1000;

        int[] data = new int[MAX_LEN];
        int len = 0;

        public TwoSum() {
        }

        public void add(int number) {

            map.merge(number, 1, Integer::sum);

            if (len >= MAX_LEN) {
                return;
            }

            if (len == 0) {
                data[len++] = number;
                return;
            }

            int i = 0;

            while (i < len && data[i] < number) {
                i++;
            }

            for (int j = len + 1; j > i; j--) {
                data[j] = data[j - 1];
            }

            data[i] = number;
            len++;
        }

        public boolean find(int value) {

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                int x = entry.getKey(), y = entry.getValue();

                if (map.containsKey(value - x) && (x != value || y > 1)) {
                    return true;
                }

            }

            return false;
        }

        public boolean find2(int value) {

            int left = 0, right = len - 1;

            while (left < right) {

                if (data[left] + data[right] == value) {
                    return true;
                } else if (data[left] + data[right] > value) {
                    right--;
                } else {
                    left++;
                }

            }

            return false;
        }
    }

    @Test
    public void test() {

        TwoSum twoSum = new TwoSum();

        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        twoSum.add(2);

        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));
        System.out.println(twoSum.find2(8));
        System.out.println(twoSum.find2(6));
    }

}
