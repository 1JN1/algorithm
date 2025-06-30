package day_41;

import day_29.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 王文涛
 * @date 2024/11/6
 * @description 二叉搜索树迭代器
 **/
public class Problem01 {

    class BSTIterator {

        List<Integer> valList = new ArrayList<>();

        int idx = 0;

        public BSTIterator(TreeNode root) {


            Stack<TreeNode> stack = new Stack<>();

            while (root != null || !stack.isEmpty()) {
                // 左子树一路入栈
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                valList.add(root.val);
                root = root.right;
            }

        }

        public int next() {

            return valList.get(idx++);
        }

        public boolean hasNext() {

            if (idx >= valList.size()) {
                return false;
            }

            return true;
        }
    }

    @Test
    public void test() {


        TreeNode tree = TreeNode.buildTreeByLevel(new int[]{7, 3, 15, -1, -1, 9, 20});

        BSTIterator iterator = new BSTIterator(tree);

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

    }


}
