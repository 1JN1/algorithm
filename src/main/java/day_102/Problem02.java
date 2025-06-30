package day_102;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/3/8
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] target = {2, 3, 4};
        int n = 4;

        System.out.println(buildArray(target, n));

    }

    public List<String> buildArray(int[] target, int n) {


        int idx = 1;

        List<String> list = new ArrayList<>();

        int len = target.length;

        for (int i = 0; i < len; i++) {

            if (target[i] == idx) {
                list.add("Push");
                idx++;
            } else {

                int diff = target[i] - idx;

                for (int j = 0; j < diff; j++) {
                    list.add("Push");
                }

                for (int j = 0; j < diff; j++) {
                    list.add("Pop");
                }
                idx = target[i];
                i--;
            }

        }


        return list;
    }

}
