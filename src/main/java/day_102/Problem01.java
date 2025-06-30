package day_102;

import day_29.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/3/8
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel2(new Integer[]{8, 17, 21, 18, null, null, 6});

        System.out.println(Arrays.toString(decorateRecord(root)));

    }

    public int[] decorateRecord(TreeNode root) {

        if (root == null){
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            list.add(cur.val);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}
