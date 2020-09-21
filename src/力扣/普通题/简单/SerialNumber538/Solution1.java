package 力扣.普通题.简单.SerialNumber538;

import java.util.*;

/**
 * @date 2020-09-21
 */
public class Solution1 {

    List<TreeNode> list = new LinkedList<>();

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        // 降序排序
        list.sort((o1, o2) -> o2.val - o1.val);
        for (int i = 1; i < list.size(); i++) {
            list.get(i).val += list.get(i - 1).val;
        }
        return root;
    }

    public void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode);
        dfs(treeNode.left);
        dfs(treeNode.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
