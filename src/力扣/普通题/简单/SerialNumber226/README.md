## 226. 翻转二叉树（简单）

**链接**：https://leetcode-cn.com/problems/invert-binary-tree/

### 题目

&emsp;&emsp;翻转一棵二叉树。

**示例：**

&emsp;&emsp;输入：

````
     4
   /   \
  2     7
 / \   / \
1   3 6   9
````

&emsp;&emsp;输出：

````
     4
   /   \
  7     2
 / \   / \
9   6 3   1
````
### 解题思路

&emsp;&emsp;这道题比较简单，只要递归的将当前节点的左右子树交换，直到结点为空即可。

### 代码

[代码链接](Solution.java)

![提交记录](226.png)