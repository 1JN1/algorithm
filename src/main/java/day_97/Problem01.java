package day_97;

/**
 * @author 王文涛
 * @date 2025/2/26
 * @description
 **/
public class Problem01 {

    public int countHomogenous(String s) {

        int n = s.length();
        int i = 0, j = 0;
        long count = 0;

        while (j < n) {

            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            long size = j - i;

            count += (size * (size + 1)) / 2;

            i = j;

        }

        return (int) (count % (1e9 + 7));
    }

}
