package day_171;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/10 9:43
 */
public class Problem01 {

    @Test
    public void test() {
        TreeNode root = TreeNode.buildTreeByLevel2(
                new Integer[]{4, 2, 9, 3, 5, null, 7}
        );
        System.out.println(findTilt(root));
    }

    int ans = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return ans;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        ans += Math.abs(left - right);

        return left + right + root.val;
    }

}
