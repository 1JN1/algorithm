package day_106;

import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/3/13
 * @description
 **/
public class Problem01 {

    public String bestHand(int[] ranks, char[] suits) {

        int[] rankCount = new int[14];
        int[] suitCount = new int[4];

        int len1 = ranks.length, len2 = suits.length;

        for (char suit : suits) {
            suitCount[suit - 'a']++;
        }

        for (int i = 0; i < 4; i++) {
            if (suitCount[i] >= 5) {
                return "Flush";
            }
        }

        for (int rank : ranks) {
            rankCount[rank]++;
        }

        int max = 0;
        for (int i = 0; i < 14; i++) {
            max = Math.max(max, rankCount[i]);
        }

        if (max >= 3) {
            return "Three of a Kind";
        } else if (max == 2) {
            return "Pair";
        }

        return "High Card";
    }

}
