package day_56;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/21
 * @description 打家劫舍III
 **/
public class Problem04 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel(new int[]{2, 1, 3, -1, 4});

        System.out.println(rob(root));

    }

    public int rob(TreeNode root) {


        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        // 不偷左子树根节点的最大金额
        int leftNoRoot = 0;
        // 偷左子树根节点的最大金额
        int leftHaveRoot = 0;
        if (root.left != null) {
            leftNoRoot = rob(root.left.left) + rob(root.left.right);
            leftHaveRoot = root.left.val;
            if (root.left.left != null) {
                leftHaveRoot += rob(root.left.left.left) + rob(root.left.left.right);
            }
            if (root.left.right != null) {
                leftHaveRoot += rob(root.left.right.left) + rob(root.left.right.right);
            }
        }

        // 不偷右子树根节点的最大金额
        int rightNoRoot = 0;
        // 偷左子树根节点的最大金额
        int rightHaveRoot = 0;
        if (root.right != null) {
            rightNoRoot = rob(root.right.left) + rob(root.right.right);
            rightHaveRoot = root.right.val;
            if (root.right.left != null) {
                rightHaveRoot += rob(root.right.left.left) + rob(root.right.left.right);
            }
            if (root.right.right != null) {
                rightHaveRoot += rob(root.right.right.left) + rob(root.right.right.right);
            }
        }

        int result = leftNoRoot + rightNoRoot + root.val;
        result = Math.max(result, Math.max(leftNoRoot, leftHaveRoot) + Math.max(rightNoRoot, rightHaveRoot));

        return result;
    }

    public int rob2(TreeNode root) {

        int[] res = dfs(root);

        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int selected = left[1] + right[1] + root.val;
        int unselected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{selected, unselected};
    }

}
