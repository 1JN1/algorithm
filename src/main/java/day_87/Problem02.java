package day_87;

/**
 * @author 王文涛
 * @date 2025/2/14
 * @description
 **/
public class Problem02 {

    public char nextGreatestLetter(char[] letters, char target) {

        int n = letters.length;

        int left = 0, right = n - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return letters[left] > target ? letters[left] : letters[0];
    }

}
