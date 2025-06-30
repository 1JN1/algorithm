package day_27;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/13
 * @description 格雷编码
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(grayCode(5));

    }

    public List<Integer> grayCode(int n) {

        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            ret.add((i >> 1) ^ i);
        }

        return ret;
    }

    public List<Integer> grayCode2(int n) {

        List<Integer> ret = new ArrayList<>();

        ret.add(0);

        int head = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = ret.size() - 1; j >= 0; j--) {
                ret.add(head + ret.get(j));
            }

            head <<= 1;
        }

        return ret;
    }

}
