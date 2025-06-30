package day_134;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/11
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 2 ，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 3 ，并将其从集合中移除。
        smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 在上一步中被添加到集合中，
        // 且 1 是最小的整数，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 4 ，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 5 ，并将其从集合中移除。

    }

    class SmallestInfiniteSet {

        private boolean[] set;

        private int smallest;

        public SmallestInfiniteSet() {
            smallest = 1;
            set = new boolean[1001];
        }

        public int popSmallest() {

            int ans = smallest;

            while (set[ans]) {
                ans++;
            }

            set[ans] = true;
            smallest = ans + 1;

            return ans;
        }

        public void addBack(int num) {

            if (set[num]) {
                set[num] = false;
                smallest = Math.min(smallest, num);
            }
        }
    }
}
