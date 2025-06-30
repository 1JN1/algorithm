package day_90;

/**
 * @author 王文涛
 * @date 2025/2/18
 * @description
 **/
public class Problem05 {
    public void reverseString(char[] s) {

        int left = 0, right = s.length - 1;

        while (left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }
}
