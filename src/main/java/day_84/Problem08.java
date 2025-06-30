package day_84;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/10
 * @description
 **/
public class Problem08 {

    public String crackPassword(int[] password) {

        String[] strs = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            strs[i] = String.valueOf(password[i]);
        }

        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

}
