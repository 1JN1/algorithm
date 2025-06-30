package day_80;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/2
 * @description
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));

    }

    public String validIPAddress(String queryIP) {

        // 可能是IPV4
        if (queryIP.contains(".")) {
            return checkIPV4(queryIP);
            // IPV6
        } else if (queryIP.contains(":")) {
            return checkIPV6(queryIP);
        } else {
            return "Neither";
        }
    }

    public String checkIPV4(String queryIP) {

        if(queryIP.lastIndexOf(".") == queryIP.length()-1){
            return "Neither";
        }

        String[] strings = queryIP.split("\\.");

        if (strings.length != 4) {
            return "Neither";
        }

        for (int i = 0; i < 4; i++) {

            String s = strings[i];

            try{
                if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) {
                    return "Neither";
                } else if (s.length() >= 2 && s.charAt(0) == '0') {
                    return "Neither";
                }
            }catch (Exception e){
                return "Neither";
            }

        }

        return "IPv4";
    }

    public String checkIPV6(String queryIP) {


        if (queryIP.lastIndexOf(":") == queryIP.length() - 1) {
            return "Neither";
        }

        String[] strings = queryIP.split(":");

        if (strings.length != 8) {
            return "Neither";
        }

        for (int i = 0; i < 8; i++) {

            String s = strings[i];

            // 长度不是1-4
            if (s.length() > 4 || s.isEmpty()) {
                return "Neither";
            }

            for (int j = 0; j < s.length(); j++) {

                char ch = s.charAt(j);

                // 既不是数字也不是字母
                if (!Character.isLetterOrDigit(ch)) {
                    return "Neither";
                }

                // 是字母
                if (Character.isLetter(ch)) {

                    ch = Character.toUpperCase(ch);
                    if (ch < 'A' || ch > 'F') {
                        return "Neither";
                    }

                }

            }

        }

        return "IPv6";
    }

}
