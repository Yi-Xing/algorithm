package 力扣.普通题.中等.SerialNumber106;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2020-09-14
 */
public class Solution {

    int in;
    int po;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in=inorder.length-1;
        po=postorder.length-1;
        return dfs(Integer.MAX_VALUE,inorder,postorder);
    }

    public TreeNode dfs(int stop,int[] inorder, int[] postorder) {
        if(po<0){
            return null;
        }
        if(inorder[in]==stop){
            in--;
            return null;
        }
        TreeNode root=new TreeNode(postorder[po--]);
        root.right=dfs(root.val,inorder,postorder);
        root.left=dfs(stop,inorder,postorder);
        return root;
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
