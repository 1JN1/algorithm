package day_177;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/27 10:42
 */
public class Problem04 {

    @Test
    public void test() {
        int[][] events = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(maxEvents(events));
    }

    /**
     * 使用并查集优化的活动参加问题解决方案
     * 核心思想：通过并查集快速跳过已被占用的天数，避免重复遍历
     */
    public int maxEvents(int[][] events) {
        // 贪心策略：按结束时间排序，优先参加结束时间早的活动
        // 这样能为后续活动留出更多选择空间
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        // 记录能参加的活动数量
        int count = 0;
        // 找到所有活动中最晚的结束时间
        int lastDay = events[events.length - 1][1];

        // 并查集数组：parent[i] 表示从第i天开始，下一个可用的天数
        // 初始状态：每天都指向自己，表示都可用
        // 数组大小为 lastDay + 2，是为了处理边界情况（当所有天都被占用时，指向 lastDay + 1）
        int[] parent = new int[lastDay + 2];
        for (int i = 0; i <= lastDay + 1; i++) {
            // 初始化：每个天数的下一个可用天数就是自己
            parent[i] = i;
        }

        // 遍历每个活动（已按结束时间排序）
        for (int[] event : events) {
            // 使用并查集查找从活动开始时间 event[0] 开始的第一个可用天数
            int day = find(parent, event[0]);

            // 检查找到的可用天数是否在活动的有效期内
            if (day <= event[1]) {
                // 如果可用天数在活动期间内，则可以参加这个活动

                // 关键优化：将当前天数指向下一天
                // 这样下次查找时会自动跳过已被占用的天数
                parent[day] = day + 1;

                // 成功参加一个活动
                count++;
            }
            // 如果找到的可用天数超出了活动结束时间，则无法参加这个活动
        }

        return count;
    }

    /**
     * 并查集的查找函数（带路径压缩优化）
     * 功能：查找从第x天开始，第一个可用的天数
     *
     * @param parent 并查集数组
     * @param x 要查找的起始天数
     * @return 从第x天开始第一个可用的天数
     */
    private int find(int[] parent, int x) {
        // 路径压缩：如果 parent[x] 不等于 x，说明第x天已被占用
        // 需要递归查找真正可用的天数，并将路径上的所有节点都直接指向根节点
        if (parent[x] != x) {
            // 递归查找根节点，并进行路径压缩
            // 这样下次查找相同路径时就能直接找到结果，提高效率
            parent[x] = find(parent, parent[x]);
        }
        // 返回可用的天数
        return parent[x];
    }

}
