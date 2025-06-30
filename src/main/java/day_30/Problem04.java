package day_30;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/16
 * @description 二叉树的最大深度
 **/
public class Problem04 {

    @Test
    public void test() {


    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }


        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
