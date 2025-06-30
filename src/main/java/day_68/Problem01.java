package day_68;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/12/7
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {


        RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());

    }

    class RandomizedSet {

        List<Integer> list;
        Map<Integer, Integer> map;
        Random random;

        public RandomizedSet() {

            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {

            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);

            return true;
        }

        public boolean remove(int val) {

            if (!map.containsKey(val)) {
                return false;
            }

            Integer idx = map.get(val);
            Integer last = list.get(list.size() - 1);

            map.put(last, idx);
            list.set(idx, last);
            list.remove(list.size() - 1);
            map.remove(val);


            return true;
        }

        public int getRandom() {

            int idx = random.nextInt(list.size());

            return list.get(idx);
        }
    }

}
