package day_72;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/1/18
 * @description
 **/
public class Problem03 {

    @Test
    public void test() {

    }

    public int[][] reconstructQueue(int[][] people) {


        // 先按照身高从大到小排列
        Arrays.sort(
                people, (int[] people1, int[] people2) -> {

                    if (people1[0] != people2[0]) {
                        return people2[0] - people1[0];
                    }
                    return people1[1] - people2[1];
                }
        );

        List<int[]> list = new ArrayList<>();

        for (int[] p : people) {
            list.add(p[1], p);
        }


        return list.toArray(new int[list.size()][]);
    }

}
