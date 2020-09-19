package 力扣.普通题.简单.SerialNumber404;

/**
 * @date 2020-09-19
 */
public class Solution {

    int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode a = new TreeNode(20);
        a.left = new TreeNode(15);
        a.right = new TreeNode(7);
        root.right = a;
        Solution solution = new Solution();
        solution.sumOfLeftLeaves(root);
        System.out.println(solution.sum);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null){
                sum+=root.left.val;
            }else {
                sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sumOfLeftLeaves(root.right);
        }
        return sum;
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
