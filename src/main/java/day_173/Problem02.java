package day_173;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/15 9:36
 */
public class Problem02 {

    public boolean canAliceWin(int n) {

        return (n >= 10 && n < 19) ||
                (n >= 27 && n < 34) ||
                (n >= 40 && n < 45) ||
                n >= 49;
    }
}
