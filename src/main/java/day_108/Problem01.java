package day_108;

/**
 * @author 王文涛
 * @date 2025/3/16
 * @description
 **/
public class Problem01 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {

        int distance = distance(new int[]{0, 0}, target);

        for (int[] ghost : ghosts) {
            if (distance(ghost, target) <= distance) {
                return false;
            }
        }

        return true;
    }

    public int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

}
