package day_32;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/20
 * @description 杨辉三角
 **/
public class Problem05 {

    @Test
    public void test() {

        generate(5).forEach(System.out::println);

    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }

        result.add(Collections.singletonList(1));

        for (int i = 2; i <= numRows; i++) {

            List<Integer> temp = new ArrayList<>();
            List<Integer> last = result.get(i - 2);
            temp.add(1);
            for (int j = 1; j < last.size(); j++) {
                temp.add(last.get(j - 1) + last.get(j));
            }
            temp.add(1);

            result.add(temp);
        }

        return result;
    }

}
