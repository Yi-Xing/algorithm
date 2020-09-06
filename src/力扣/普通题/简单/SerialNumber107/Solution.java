package 力扣.普通题.简单.SerialNumber107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 2020-09-05
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点入队
        queue.offer(root);
        // 如果队列不为空，则一直执行
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            // 遍历现队列中的每一个元素
            for (int i = 0; i < size; i++) {
                // 取得队首元素，加入集合中
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                // 将当前结点的左右在子结点加入列表中
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            // 每次将集合添加到总集合的头部
            levelOrder.add(0, level);
        }
        return levelOrder;
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
