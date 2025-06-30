package day_42;

import day_29.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 王文涛
 * @date 2024/11/7
 * @description 二叉树的右视图
 **/
public class Problem02 {

    @Test
    public void test() {

        TreeNode tree = TreeNode.buildTreeByLevel(new int[]{1, 2, 3, -1, 5, -1, 4});

        System.out.println(rightSideView(tree));

    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }

        }


        return ans;
    }

}
