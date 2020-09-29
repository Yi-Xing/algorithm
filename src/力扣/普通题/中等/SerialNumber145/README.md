## 145. 二叉树的后序遍历（中等）

**链接**：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/

### 题目

&emsp;&emsp;给定一个二叉树，返回它的 后序 遍历。

**示例:**

&emsp;&emsp;输入: [1,null,2,3]

```
   1
    \
     2
    /
   3 
```

&emsp;&emsp;输出: [3,2,1]

&emsp;&emsp;进阶: 递归算法很简单，你可以通过迭代算法完成吗？

### 解题思路

&emsp;&emsp;后序遍历：在二叉树中，先左后右再根，即首先遍历左子树，然后遍历右子树，最后访问根结点。

### 代码

[代码链接](Solution.java)

![提交记录](145.png)