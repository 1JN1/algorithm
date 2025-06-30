package day_128;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/4/30
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        List<Integer> processorTime = Arrays.asList(121,99);
        List<Integer> tasks = Arrays.asList(287,315,293,260,333,362,69,233);

        System.out.println(minProcessingTime(processorTime, tasks));
    }

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {

        tasks.sort(
                (a, b) -> b - a
        );

        processorTime.sort(
                Comparator.comparingInt(a -> a)
        );

        int minTime = 0;
        int idx = 0;

        for (int time : processorTime) {
            minTime = Math.max(minTime, time + tasks.get(idx));
            idx += 4;
        }

        return minTime;
    }

}
