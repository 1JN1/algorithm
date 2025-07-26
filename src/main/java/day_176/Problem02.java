package day_176;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/26 10:15
 */
public class Problem02 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel2(
                new Integer[]{2, 3, 1, 3, 1, null, 1}
        );

        System.out.println(pseudoPalindromicPaths(root));

    }

    public int pseudoPalindromicPaths(TreeNode root) {

        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int oddMask) {
        if (root == null) {
            return 0;
        }

        // 翻转对应位的状态
        oddMask ^= (1 << root.val);

        // 到达叶子节点
        if (root.left == null && root.right == null) {
            // 最多只能有一个数字出现奇数次（oddMask最多只能有一个1）
            return (oddMask & (oddMask - 1)) == 0 ? 1 : 0;
        }

        return dfs(root.left, oddMask) + dfs(root.right, oddMask);
    }

}
