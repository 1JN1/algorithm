package day_154;

import day_29.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/6/5
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        TreeNode root = TreeNode.buildTreeByLevel2(new Integer[]{1});
        System.out.println(amountOfTime(root, 1));
    }

    public int amountOfTime(TreeNode root, int start) {

        // 构建节点到父节点的关系
        Map<Integer, TreeNode> parent = new HashMap<>();
        Map<Integer, TreeNode> num2Node = new HashMap<>();
        TreeNode cur = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                parent.put(cur.left.val, cur);
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                parent.put(cur.right.val, cur);
                queue.offer(cur.right);
            }
            num2Node.put(cur.val, cur);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        TreeNode startNode = num2Node.get(start);
        queue.offer(startNode);
        int time = 0;
        while (!queue.isEmpty()) {

            // 取出queue现在的节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left.val)) {
                    queue.offer(node.left);
                    visited.add(node.left.val);
                }
                if (node.right != null && !visited.contains(node.right.val)) {
                    queue.offer(node.right);
                    visited.add(node.right.val);
                }
                if (parent.containsKey(node.val) && !visited.contains(parent.get(node.val).val)) {
                    queue.offer(parent.get(node.val));
                    visited.add(parent.get(node.val).val);
                }
            }

            time++;
        }

        return time - 1;
    }

}
