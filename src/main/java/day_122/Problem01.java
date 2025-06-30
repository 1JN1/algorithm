package day_122;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/4/17
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] arr = {1, 2, 3};

        System.out.println(subarrayBitwiseORs(arr));

    }

    public int subarrayBitwiseORs(int[] arr) {

        List<List<Integer>> res = generateContinuousSubsequences(arr);

        Set<Integer> set = new HashSet<>();

        for (List<Integer> list : res) {
            set.add(bitwiseOr(list));
        }

        return set.size();
    }

    public List<List<Integer>> generateContinuousSubsequences(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                cur.add(arr[j]);
                res.add(new ArrayList<>(cur));
            }
        }

        return res;
    }

    public int bitwiseOr(List<Integer> arr) {
        int ans = 0;
        for (Integer integer : arr) {
            ans |= integer;
        }

        return ans;
    }

    public int subarrayBitwiseORs2(int[] arr) {
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            Set<Integer> cur = new HashSet<>();
            cur.add(num);

            for (int val : prev) {
                cur.add(val | num);
            }

            resultSet.addAll(cur);
            prev = cur;
        }

        return resultSet.size();
    }

}
