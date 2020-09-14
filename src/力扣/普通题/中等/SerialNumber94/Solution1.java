package 力扣.普通题.中等.SerialNumber94;

import java.util.*;

/**
 * @date 2020-09-14
 */
public class Solution1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    public void dfs(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs(list, treeNode.left);
        list.add(treeNode.val);
        dfs(list, treeNode.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
