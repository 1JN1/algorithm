package day_92;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/21
 * @description
 **/
public class Problem02 {

    public int numRescueBoats(int[] people, int limit) {

        int n = people.length;
        Arrays.sort(people);

        int low = 0, high = n - 1;
        int count = 0;

        while (low <= high) {

            if (people[low] + people[high] <= limit) {
                low++;
            }

            high--;
            count++;

        }

        return count;
    }

}
