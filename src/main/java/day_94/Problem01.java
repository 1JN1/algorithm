package day_94;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 王文涛
 * @date 2025/2/24
 * @description
 **/
public class Problem01 {


    @Test
    public void test() {
        System.out.println(powerfulIntegers(2, 2, 400000));
    }


    public List<Integer> powerfulIntegers(int x, int y, int bound) {


        Set<Integer> set = new HashSet<>();

        // 计算 i 的最大值
        int maxI = (x == 1) ? 1 : (int) (Math.log(bound) / Math.log(x));
        // 计算 j 的最大值
        int maxJ = (y == 1) ? 1 : (int) (Math.log(bound) / Math.log(y));

        // 遍历所有可能的 i 和 j
        for (int i = 0; i <= maxI; i++) {
            for (int j = 0; j <= maxJ; j++) {
                int sum = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (sum <= bound) {
                    set.add(sum);
                } else {
                    break; // 如果 sum > bound，继续增加 j 只会使 sum 更大，所以直接跳出内层循环
                }
            }
        }

        return new ArrayList<>(set);
    }

}
