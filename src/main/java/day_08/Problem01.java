package day_08;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/13
 * @description 字符串转换成整数
 **/

public class Problem01 {


    @Test
    public void test() {

        System.out.println(myAtoi("-42"));

    }

    public int myAtoi(String s) {

        AutoStateMachine autoStateMachine = new AutoStateMachine();

        char[] chars = s.toCharArray();

        if (chars.length == 0) {
            return 0;
        }

        for (char c : chars) {

            autoStateMachine.get(c);

        }


        return autoStateMachine.symbol * (int)autoStateMachine.ans;
    }


}
