package day_50;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description 最接近的二叉搜索树值
 **/
public class Problem02 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel(new int[]{4, 2, 5, 1, 3});

        System.out.println(closestValue(root, 4.0));

    }

    public int closestValue(TreeNode root, double target) {

        int ans = 0;
        Double diff = Double.MAX_VALUE;

        while (root != null) {

            Double curDiff = Math.abs(root.val - target);

            if (curDiff.compareTo(diff) < 0) {
                ans = root.val;
                diff = curDiff;
            } else if (curDiff.equals(diff)) {
                ans = Math.min(ans, root.val);
            }

            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                return root.val;
            }

        }

        return ans;
    }

}
