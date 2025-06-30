package day_158;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 王文涛
 * @date 2025/6/11
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] nums = {1, 2, 2, 2, 2};
        System.out.println(minimumOperations(nums));
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0; // 只有一个元素，不需要任何操作

        // 奇数位置数字频率
        Map<Integer, Integer> oddMap = new HashMap<>();
        for (int i = 0; i < n; i += 2) {
            oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
        }

        // 偶数位置数字频率
        Map<Integer, Integer> evenMap = new HashMap<>();
        for (int i = 1; i < n; i += 2) {
            evenMap.put(nums[i], evenMap.getOrDefault(nums[i], 0) + 1);
        }

        // 获取奇数位的前两个最频繁数字及其计数
        int oddFirst = -1, oddFirstCount = 0;
        int oddSecond = -1, oddSecondCount = 0;
        for (Map.Entry<Integer, Integer> entry : oddMap.entrySet()) {
            if (entry.getValue() > oddFirstCount) {
                oddSecond = oddFirst;
                oddSecondCount = oddFirstCount;
                oddFirst = entry.getKey();
                oddFirstCount = entry.getValue();
            } else if (entry.getValue() > oddSecondCount) {
                oddSecond = entry.getKey();
                oddSecondCount = entry.getValue();
            }
        }

        // 获取偶数位的前两个最频繁数字及其计数
        int evenFirst = -1, evenFirstCount = 0;
        int evenSecond = -1, evenSecondCount = 0;
        for (Map.Entry<Integer, Integer> entry : evenMap.entrySet()) {
            if (entry.getValue() > evenFirstCount) {
                evenSecond = evenFirst;
                evenSecondCount = evenFirstCount;
                evenFirst = entry.getKey();
                evenFirstCount = entry.getValue();
            } else if (entry.getValue() > evenSecondCount) {
                evenSecond = entry.getKey();
                evenSecondCount = entry.getValue();
            }
        }

        // 计算最小操作次数
        int oddSize = (n + 1) / 2;
        int evenSize = n / 2;

        if (oddFirst != evenFirst) {
            return (oddSize - oddFirstCount) + (evenSize - evenFirstCount);
        } else {
            // 情况1: 奇数位用第一频繁，偶数位用第二频繁
            int option1 = evenSecond == -1 ? Integer.MAX_VALUE :
                    (oddSize - oddFirstCount) + (evenSize - evenSecondCount);

            // 情况2: 奇数位用第二频繁，偶数位用第一频繁
            int option2 = oddSecond == -1 ? Integer.MAX_VALUE :
                    (oddSize - oddSecondCount) + (evenSize - evenFirstCount);

            // 情况3: 如果只有一种数字，必须全部改变
            if (option1 == Integer.MAX_VALUE && option2 == Integer.MAX_VALUE) {
                return Math.min(oddSize, evenSize);
            }

            return Math.min(option1, option2);
        }
    }

}
