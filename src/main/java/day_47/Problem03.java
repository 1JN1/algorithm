package day_47;

import day_09.ListNode;
import day_29.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 王文涛
 * @date 2024/11/12
 * @description 二叉树的最近公共祖先
 **/
public class Problem03 {

    @Test
    public void test() {


        TreeNode root = TreeNode.buildTreeByLevel(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});

        TreeNode p = root.left, q = root.right;

        System.out.println(lowestCommonAncestor(root, p, q));

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> path1 = findPath(root, p);
        List<TreeNode> path2 = findPath(root, q);

        List<TreeNode> maxPath, minPath;

        if (path1.size() > path2.size()) {
            maxPath = path1;
            minPath = path2;
        } else {
            maxPath = path2;
            minPath = path1;
        }

        int i = 0, j = maxPath.size() - minPath.size();

        while (i < minPath.size() && j < maxPath.size()) {
            if (minPath.get(i++) == maxPath.get(j++)) {
                return minPath.get(i - 1);
            }
        }


        return null;
    }

    public List<TreeNode> findPath(TreeNode root, TreeNode node) {

        // 利用后序遍历，找节点的路径
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;

        List<TreeNode> ans = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.peek();

            if (root.right != null && root.right != last) {
                root = root.right;
            } else {
                root = stack.pop();

                if (root == node) {
                    ans.add(root);
                    while (!stack.isEmpty()) {
                        ans.add(stack.pop());
                    }


                }

                last = root;
                root = null;
            }

        }

        return ans;
    }

}
