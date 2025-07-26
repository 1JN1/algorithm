package day_176;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/26 11:24
 */
public class Problem04 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel2(
                new Integer[]{5, 3, 6, 2, 4, null, null, 1}
        );

        int k = 6;

        System.out.println(kthSmallest(root, k));

    }

    public int kthSmallest(TreeNode root, int k) {

        int leftNum = count(root.left);

        if (leftNum == k - 1) {
            return root.val;
        }

        if (leftNum > k - 1) {
            return kthSmallest(root.left, k);
        }

        return kthSmallest(root.right, k - leftNum - 1);
    }

    public int count(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return count(root.left) + count(root.right) + 1;
    }

}
