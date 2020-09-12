## 637. 二叉树的层平均值（简单）

**链接**：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/

### 题目

&emsp;&emsp;给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。

**示例 1：**

&emsp;&emsp;输入：
```
    3
   / \
  9  20
    /  \
   15   7
```
&emsp;&emsp;输出：[3, 14.5, 11]

**解释：**

&emsp;&emsp;第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。


### 解题思路

&emsp;&emsp;对二叉树进行层次遍历即可。

### 代码

**方法一：**

&emsp;&emsp;使用优先队列进行层次遍历。

[代码链接](Solution1.java)

![提交记录](637(1).png)

**方法二：**

&emsp;&emsp;使用递归方式进行层次遍历。

[代码链接](Solution2.java)

![提交记录](637(2).png)