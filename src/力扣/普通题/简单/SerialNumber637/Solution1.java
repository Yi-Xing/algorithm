package 力扣.普通题.简单.SerialNumber637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 2020-09-12
 */
public class Solution1 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int count;
            int size = queue.size();
            // 将队列中原来的数取出
            for (count = 0; count < size; count++) {
                TreeNode treeNode = queue.poll();
                sum += treeNode.val;
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            list.add(sum / count);
        }
        return list;
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
