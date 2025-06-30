package day_165;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/29
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(leastMinutes(3));
    }

    public int leastMinutes(int n) {


        int count = 0;
        int download = 1;


        while (download < n){
            download *= 2;
            count++;
        }

        return count + 1;
    }

}
