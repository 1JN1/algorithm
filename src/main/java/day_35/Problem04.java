package day_35;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/25
 * @description 加油站
 **/
public class Problem04 {

    @Test
    public void test() {

        int[] gas = {4};
        int[] cost = {5};

        System.out.println(canCompleteCircuit(gas, cost));

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        int beginIdx = 0;


        while (beginIdx < n) {

            while (beginIdx < n && gas[beginIdx] < cost[beginIdx]) {
                beginIdx++;
            }

            if (beginIdx == n) {
                return -1;
            }

            int i = (beginIdx + 1) % n;
            int leftGas = gas[beginIdx] - cost[beginIdx];

            while (i != beginIdx) {

                if (gas[i] + leftGas < cost[i]) {
                    break;
                }

                leftGas = gas[i] + leftGas - cost[i];

                i = (i + 1) % n;

            }

            if (i == beginIdx) {
                return beginIdx;
            } else if (i > beginIdx) {
                beginIdx = i;
            } else {
                break;
            }

        }

        return -1;
    }

}
