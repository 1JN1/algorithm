package day_166;

import org.junit.Test;

import java.util.List;

/**
 * @author 王文涛
 * @date 2025/6/30
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        List<List<Integer>> arrays = List.of(
                List.of(1, 5),
                List.of(3, 4)
        );
        System.out.println(maxDistance(arrays));
    }

    public int maxDistance(List<List<Integer>> arrays) {

        List<Integer> first = arrays.get(0);

        int min = first.get(0);
        int max = first.get(first.size() - 1);

        int res = 0;

        int n = arrays.size();

        for (int i = 1; i < n; i++){
            List<Integer> array = arrays.get(i);
            res = Math.max(
                    res,
                    Math.max(Math.abs(array.get(0) - max),
                            Math.abs(array.get(array.size() - 1) - min)));
            min = Math.min(min, array.get(0));
            max = Math.max(max, array.get(array.size() - 1));
        }

        return res;
    }
}
