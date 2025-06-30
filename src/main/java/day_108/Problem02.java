package day_108;

/**
 * @author 王文涛
 * @date 2025/3/16
 * @description
 **/
public class Problem02 {

    public String interpret(String command) {

        StringBuilder builder = new StringBuilder();

        int len = command.length();

        int i = 0;

        while (i < len) {

            char c = command.charAt(i);

            if (c == 'G') {
                builder.append(c);
                i++;
            } else if (c == '(') {

                char next = command.charAt(i + 1);
                if (next == ')') {
                    builder.append("o");
                    i += 2;
                } else {
                    builder.append("al");
                    i += 4;
                }

            }

        }

        return builder.toString();
    }

}
