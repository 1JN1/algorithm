package day_48;

import day_29.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description 二叉树的所有路径
 **/
public class Problem05 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel(new int[]{1, 2, 3, -1, 5});
        System.out.println(binaryTreePaths(root));

    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();

        getPaths(root, "", paths);

        return paths;
    }

    public void getPaths(TreeNode root, String path, List<String> paths) {

        if (root != null) {
            StringBuilder builder = new StringBuilder(path);
            builder.append(root.val);

            if (root.left == null && root.right == null) {
                paths.add(builder.toString());
                return;
            }

            builder.append("->");
            getPaths(root.left, builder.toString(), paths);
            getPaths(root.right, builder.toString(), paths);

        }

    }

}
