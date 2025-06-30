package day_53;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/18
 * @description 区域和检索-数组可修改
 **/
public class Problem03 {

    @Test
    public void test() {

        NumArray2 numArray = new NumArray2(new int[]{1, 3, 5,});

        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));

    }

    class NumArray {

        int[] sums;

        public NumArray(int[] nums) {

            int n = nums.length;

            sums = new int[n + 1];

            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }

        }

        public void update(int index, int val) {

            int n = sums.length;

            int diff = sums[index + 1] - sums[index] - val;

            for (int i = index + 1; i < n; i++) {
                sums[i] -= diff;
            }

        }

        public int sumRange(int left, int right) {

            return sums[right + 1] - sums[left];
        }
    }

    class NumArray1 {

        // 每块元素和
        int[] sums;
        // 块大小
        int size;
        // 构造数据
        int[] nums;

        public NumArray1(int[] nums) {

            this.nums = nums;

            int n = nums.length;

            size = (int) Math.sqrt(n);

            sums = new int[(n + size - 1) / size];

            for (int i = 0; i < n; i++) {
                sums[i / size] += nums[i];
            }

        }

        public void update(int index, int val) {

            sums[index / size] += val - nums[index];

            nums[index] = val;
        }

        public int sumRange(int left, int right) {

            int b1 = left / size, i1 = left % size, b2 = right / size, i2 = right % size;

            // 位于同一块
            if (b1 == b2) {

                int sum = 0;
                for (int i = i1; i <= i2; i++) {
                    sum += nums[i + b1 * size];
                }

                return sum;
            }

            int sum1 = 0, sum2 = 0, sum3 = 0;

            for (int i = i1; i < size; i++) {
                sum1 += nums[i + b1 * size];
            }

            for (int i = 0; i <= i2; i++) {
                sum2 += nums[i + b2 * size];
            }

            for (int i = (b1 + 1) * size; i < b2 * size; i++) {
                sum3 += nums[i];
            }

            return sum1 + sum2 + sum3;
        }
    }

    class NumArray2 {

        private int[] treeArray;
        private int n;

        NumArray2(int[] nums) {

            n = nums.length;

            treeArray = new int[n * 4];

            build(nums, 0, 0, n - 1);

        }

        public void update(int index, int val) {

            change(index, val, 0, 0, n - 1);
        }

        public int sumRange(int left, int right) {

            return range(left, right, 0, 0, n - 1);
        }

        private void build(int[] nums, int node, int begin, int end) {

            if (begin == end) {
                treeArray[node] = nums[begin];
                return;
            }

            int m = begin + (end - begin) / 2;

            // 构建左子树
            build(nums, node * 2 + 1, begin, m);
            // 构建右子树
            build(nums, node * 2 + 2, m + 1, end);

            treeArray[node] = treeArray[node * 2 + 1] + treeArray[node * 2 + 2];
        }

        private void change(int index, int val, int node, int begin, int end) {

            if (begin == end) {
                treeArray[node] = val;
                return;
            }

            int m = begin + (end - begin) / 2;

            if (index <= m) {
                change(index, val, node * 2 + 1, begin, m);
            } else {
                change(index, val, node * 2 + 2, m + 1, end);
            }

            treeArray[node] = treeArray[node * 2 + 1] + treeArray[node * 2 + 2];
        }

        private int range(int left, int right, int node, int begin, int end) {

            if (left == begin && right == end) {
                return treeArray[node];
            }

            int m = begin + (end - begin) / 2;

            if (right <= m) {
                return range(left, right, node * 2 + 1, begin, m);
            } else if (left > m) {
                return range(left, right, node * 2 + 2, m + 1, end);
            } else {


                return range(left, m, node * 2 + 1, begin, m) + range(m + 1, right, node * 2 + 2, m + 1, end);
            }

        }

    }

    class NumArray3 {

        int[] tree;
        int[] nums;

        public NumArray3(int[] nums) {
            this.nums = nums;
            tree = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {

            add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {

            return count(right + 1) - count(left);
        }


        private int lowBit(int x) {
            return x & -x;
        }

        private void add(int index, int val) {

            while (index < tree.length) {
                tree[index] += val;
                index += lowBit(index);
            }

        }

        private int count(int x) {
            int result = 0;
            while (x > 0) {
                result += tree[x];
                x -= lowBit(x);
            }

            return result;
        }
    }

}
