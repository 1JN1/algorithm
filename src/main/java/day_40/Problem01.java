package day_40;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/5
 * @description Excel表列名称
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(convertToTitle2(26 * 26));

    }

    public String convertToTitle(int columnNumber) {

        StringBuilder builder = new StringBuilder();

        while (columnNumber != 0) {

            int num = columnNumber % 26;

            // 26的倍数
            if (num == 0) {
                builder.insert(0, 'Z');
                columnNumber = columnNumber / 26 - 1;
            } else {
                builder.insert(0, (char) (num + 'A' - 1));
                columnNumber = columnNumber / 26;
            }

        }

        return builder.toString();
    }

    public String convertToTitle2(int columnNumber) {

        StringBuilder builder = new StringBuilder();

        while (columnNumber != 0) {

            columnNumber--;

            builder.insert(0, (char) (columnNumber % 26 + 'A'));

            columnNumber /= 26;

        }

        return builder.toString();
    }

}
