package day_122;

/**
 * @author 王文涛
 * @date 2025/4/17
 * @description
 **/
public class Problem02 {

    class LUPrefix {

        int[] upList;
        int max = 0;

        public LUPrefix(int n) {
            this.upList = new int[n];
        }

        public void upload(int video) {
            upList[video - 1] = 1;
            while (max < upList.length && upList[max] == 1) {
                max++;
            }
        }

        public int longest() {
            return max;
        }
    }

}
