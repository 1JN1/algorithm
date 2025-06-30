package day_83;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem12 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int max = Arrays.stream(arr1).max().getAsInt();
        int min = Arrays.stream(arr1).min().getAsInt();

        int[] freq = new int[max - min + 1];

        for (int num : arr1) {
            freq[num - min]++;
        }

        int[] res = new int[arr1.length];
        int k = 0;

        for (int num : arr2) {
            for (int i = 0; i < freq[num - min]; i++) {
                res[k++] = num;
            }
            freq[num - min] = 0;

        }

        for (int i = min; i <= max; i++) {
            for (int j = 0; j < freq[i - min]; j++) {
                res[k++] = i;
            }
        }

        return res;
    }


    public int[] relativeSortArray2(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Integer[] temp = Arrays.stream(arr1).boxed().toArray(Integer[]::new);

        Arrays.sort(temp,
                (num1, num2) -> {

                    if (map.containsKey(num1)) {
                        return map.containsKey(num2) ? map.get(num1) - map.get(num2) : -1;
                    } else {
                        return map.containsKey(num2) ? 1 : num1 - num2;
                    }

                }
        );

        for (int i = 0; i < temp.length; i++) {
            arr1[i] = temp[i];
        }

        return arr1;
    }

}
