package 力扣.普通题.简单.SerialNumber617;

import 力扣.普通题.困难.SerialNumber968.Solution2;

/**
 * @date 2020-09-23
 */
public class Solution1 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 != null) {
            TreeNode root = new TreeNode(t1.val + t2.val);
            dfs(root, true, t1.left, t2.left);
            dfs(root, false, t1.right, t2.right);
            return root;
        } else if (t1 == null) {
            TreeNode root = new TreeNode(t2.val);
            dfs(root, true, null, t2.left);
            dfs(root, false, null, t2.right);
            return root;
        } else {
            TreeNode root = new TreeNode(t1.val);
            dfs(root, true, t1.left, null);
            dfs(root, false, t1.right, null);
        return root;
        }
    }

    /**
     * @param is true 为向根节点的左节点查找
     */
    public void dfs(TreeNode root, boolean is, TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return;
        }
        if (t1 != null && t2 != null) {
            if (is) {
                root.left = new TreeNode(t1.val + t2.val);
                dfs(root.left, true, t1.left, t2.left);
                dfs(root.left, false, t1.right, t2.right);
            } else {
                root.right = new TreeNode(t1.val + t2.val);
                dfs(root.right, true, t1.left, t2.left);
                dfs(root.right, false, t1.right, t2.right);
            }
        } else if (t1 == null) {
            if (is) {
                root.left = new TreeNode(t2.val);
                dfs(root.left, true, null, t2.left);
                dfs(root.left, false, null, t2.right);
            } else {
                root.right = new TreeNode(t2.val);
                dfs(root.right, true, null, t2.left);
                dfs(root.right, false, null, t2.right);
            }
        } else {
            if (is) {
                root.left = new TreeNode(t1.val);
                dfs(root.left, true, t1.left, null);
                dfs(root.left, false, t1.right, null);
            } else {
                root.right = new TreeNode(t1.val);
                dfs(root.right, true, t1.left, null);
                dfs(root.right, false, t1.right, null);
            }
        }
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
