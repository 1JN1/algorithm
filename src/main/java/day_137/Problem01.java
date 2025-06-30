package day_137;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/5/14
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        String[] names = {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        System.out.println(Arrays.toString(getFolderNames2(names)));
    }

    public String[] getFolderNames(String[] names) {

        Set<String> set = new HashSet<>();
        int n = names.length;
        String[] ans = new String[n];
        int idx = 0;

        for (String name : names) {

            if (set.contains(name)) {
                int k = 1;
                while (set.contains(name + "(" + k + ")")) {
                    k++;
                }
                name = name + "(" + k + ")";
            }

            set.add(name);
            ans[idx++] = name;
        }

        return ans;
    }

    public String[] getFolderNames2(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        int n = names.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (map.containsKey(name)) {

                int k = map.get(name);
                while (map.containsKey(name + "(" + k + ")")) {
                    k++;
                }
                map.put(name, k + 1);
                name = name + "(" + k + ")";
                map.put(name, 1);
                ans[i] = name;
            } else {
                map.put(name, 1);
                ans[i] = name;
            }
        }

        return ans;
    }
}
