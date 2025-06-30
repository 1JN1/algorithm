package day_104;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/11
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(makeGood("SAYTTveEVttyaswmMwnNCMmcnNWmMWhIgZyWnFirRIfNwYzGiHhH"));
    }


    public String makeGood(String s) {

        int len = s.length();

        if (len <= 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < len; i++) {

            if (i == len - 1) {
                builder.append(s.charAt(i));
                break;
            }

            char c1 = s.charAt(i), c2 = s.charAt(i + 1);

            if (c1 != c2 && Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                flag = true;
                i++;
                continue;
            }

            builder.append(c1);
        }

        if (!flag) {
            return s;
        }

        return makeGood(builder.toString());
    }

    public String makeGood2(String s) {

        int len = s.length();
        if (len <= 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        int idx = -1;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (builder.length() > 0 && Character.toLowerCase(c) == Character.toLowerCase(builder.charAt(idx)) && c != builder.charAt(idx)) {
                builder.deleteCharAt(idx);
                idx--;
            } else {
                builder.append(c);
                idx++;
            }
        }

        return builder.toString();
    }

}
