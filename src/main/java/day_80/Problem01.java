package day_80;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/2/2
 * @description
 **/
public class Problem01 {


    @Test
    public void test() {

        System.out.println(canIWin(10, 18));

    }


    public Map<Integer, Boolean> map = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        // 最大和比total小
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }

        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    public boolean dfs(int maxChoosableInteger, int userNumber, int total, int curTotal) {

        // 没有遇到过的场景
        if (!map.containsKey(userNumber)) {

            boolean res = false;

            // 选择数
            for (int i = 0; i < maxChoosableInteger; i++) {

                // i+1还没有被选择
                if (((userNumber >> i) & 1) == 0) {

                    // 选完之后可以直接获胜
                    if (i + 1 + curTotal >= total) {
                        res = true;
                        break;
                    }

                    // 对方没有赢
                    if (!dfs(maxChoosableInteger, userNumber | (1 << i), total, curTotal + i + 1)) {
                        res = true;
                        break;
                    }

                }

            }

            map.put(userNumber, res);
        }

        return map.get(userNumber);
    }

}
