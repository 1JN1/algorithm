package day_39;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/4
 * @description 分数到小数
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(fractionToDecimal(1, 2));

    }

    public String fractionToDecimal(int numerator, int denominator) {


        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;

        // 可以整除
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        // 获取符号位
        StringBuilder ans = new StringBuilder();

        if (numeratorLong < 0 ^ denominatorLong < 0) {
            ans.append('-');
        }

        // 计算整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);

        ans.append(numeratorLong / denominatorLong);

        ans.append('.');

        // 计算小数部分
        long remainder = numeratorLong % denominatorLong;
        Map<Long, Integer> map = new HashMap<>();
        int index = 0;
        StringBuilder builder = new StringBuilder();

        while (remainder != 0 && !map.containsKey(remainder)) {

            map.put(remainder, index);

            remainder *= 10;

            builder.append(remainder / denominatorLong);

            remainder %= denominatorLong;
            index++;

        }

        if (remainder != 0) {

            index = map.get(remainder);

            builder.insert(index, '(');
            builder.append(')');

        }

        ans.append(builder);

        return ans.toString();
    }

}
