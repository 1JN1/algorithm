package day_167;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/7/1
 * @description
 **/
public class Problem02 {

    public boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();

        boolean flag = false;

        for (int num : arr) {
            if (set.contains(num * 2)) {
                flag = true;
                break;
            }
            if (num % 2 == 0 && set.contains(num / 2)) {
                flag = true;
                break;
            }
            set.add(num);
        }

        return flag;
    }

}
