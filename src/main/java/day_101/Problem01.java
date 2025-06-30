package day_101;

import day_29.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 王文涛
 * @date 2025/3/7
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel2(new Integer[]{-100, -200, -300, -20, -5, -10, null});
        System.out.println(maxLevelSum(root));

    }

    public int maxLevelSum(TreeNode root) {


        if (root == null) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int ans = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            level++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            ans = sum > maxSum ? level : ans;
            maxSum = Math.max(sum, maxSum);

        }

        return ans;
    }
}
