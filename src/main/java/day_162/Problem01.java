package day_162;

/**
 * @author 王文涛
 * @date 2025/6/23
 * @description
 **/
public class Problem01 {

    public int countBeautifulPairs(int[] nums) {

        int ans = 0;
        int[] cnt = new int[10];

        for (int num : nums){

            for (int y = 1; y <= 9; y++){
                if (gcd(num % 10, y) == 1){
                    ans += cnt[y];
                }
            }

            while (num >= 10){
                num /= 10;
            }

            cnt[num]++;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
