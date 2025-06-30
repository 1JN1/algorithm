package day_08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/9/13
 * @description 自动状态机，用来解决Problem01的问题
 **/
public class AutoStateMachine {

    private String state = "start";

    public int symbol = 1;

    public long ans = 0;

    private static final Map<String, String[]> map = new HashMap<String, String[]>() {
        {
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
    };

    public void get(char c) {


        String newState = map.get(state)[get_col(c)];

        if ("signed".equals(newState)) {
            symbol = c == '-' ? -1 : 1;
        } else if ("in_number".equals(newState)) {
            ans = ans * 10 + c - '0';
            ans = symbol == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        }
    }

    private int get_col(char c) {

        if (c == ' ') {
            return 0;
        }

        if (c == '+' || c == '-') {
            return 1;
        }

        if (Character.isDigit(c)) {
            return 2;
        }

        return 3;
    }

}
