package day_33;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/21
 * @description 杨辉三角II
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(getRow3(33));

    }

    public List<Integer> getRow(int rowIndex) {


        List<List<Integer>> list = new ArrayList<>();

        list.add(Collections.singletonList(1));

        for (int i = 1; i <= rowIndex; i++) {

            List<Integer> temp = new ArrayList<>();
            List<Integer> preList = list.get(i - 1);

            temp.add(1);
            for (int j = 1; j < preList.size(); j++) {
                temp.add(preList.get(j - 1) + preList.get(j));
            }
            temp.add(1);

            list.add(temp);
        }

        return list.get(rowIndex);
    }

    public List<Integer> getRow2(int rowIndex) {

        List<Integer> res = new ArrayList<>();

        res.add(1);

        for (int i = 1; i <= rowIndex; i++) {

            res.add(0);

            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }

        }

        return res;
    }

    public List<Integer> getRow3(int rowIndex) {

        List<Integer> res = new ArrayList<>();

        res.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            res.add((int)((long) res.get(i - 1) * (rowIndex - i + 1) / i));
        }

        return res;
    }

}
