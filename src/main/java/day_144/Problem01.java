package day_144;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/5/23
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        System.out.println(isSubstringPresent("abcba"));
    }

    public boolean isSubstringPresent(String s) {

        boolean flag = false;

        Set<String> set = new HashSet<>();

        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 1; i < n; i++) {
            char pre = chars[i - 1];
            char cur = chars[i];
            if (pre == cur || set.contains(pre + String.valueOf(cur))) {
                flag = true;
                break;
            }
            set.add(cur + String.valueOf(pre));
        }

        return flag;
    }

}
