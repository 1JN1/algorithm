package day_177;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/27 9:47
 */
public class Problem03 {

    @Test
    public void test() {
        int[] nums = {1, 60, 34, 84, 62, 56, 39, 76, 49, 38};
        int limit = 4;
        int[] result = lexicographicallySmallestArray(nums, limit);
        System.out.println(Arrays.toString(result));
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // 创建元素及其原始索引的映射
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // 按值排序
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        int[] result = nums.clone();

        // 分组处理可以交换的连续元素
        for (int i = 0; i < n; ) {
            List<Integer> indices = new ArrayList<>();
            List<Integer> values = new ArrayList<>();

            // 收集当前组的第一个元素
            indices.add(pairs[i][1]);
            values.add(pairs[i][0]);

            int j = i + 1;
            // 找到所有可以与前一个元素交换的元素（差值 <= limit）
            while (j < n && pairs[j][0] - pairs[j-1][0] <= limit) {
                indices.add(pairs[j][1]);
                values.add(pairs[j][0]);
                j++;
            }

            // 对索引排序（按原始位置）
            indices.sort(Integer::compare);
            // values已经是排序的（因为pairs是按值排序的）

            // 将最小的值分配给最左边的位置
            for (int k = 0; k < indices.size(); k++) {
                result[indices.get(k)] = values.get(k);
            }

            i = j;
        }

        return result;
    }

}
