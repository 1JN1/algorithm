package day_83;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem01 {
    public String crackPassword(int[] password) {


        String[] passwordStr = new String[password.length];

        for (int i = 0; i < password.length; i++) {
            passwordStr[i] = String.valueOf(password[i]);
        }

        Arrays.sort(passwordStr, (pwd1, pwd2) -> (pwd1 + pwd2).compareTo(pwd2 + pwd1));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < passwordStr.length; i++) {
            sb.append(passwordStr[i]);
        }

        return sb.toString();
    }
}
