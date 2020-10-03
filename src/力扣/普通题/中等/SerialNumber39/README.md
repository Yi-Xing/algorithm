## 39. 组合总和（中等）

**链接**：https://leetcode-cn.com/problems/combination-sum/

### 题目

&emsp;&emsp;给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

**说明：**

* 所有数字（包括 target）都是正整数。
* 解集不能包含重复的组合。 

**示例 1：**

&emsp;&emsp;输入：candidates = [2,3,6,7], target = 7,

&emsp;&emsp;所求解集为：
````
[
  [7],
  [2,2,3]
]
````
**示例 2：**

&emsp;&emsp;输入：candidates = [2,3,5], target = 8,

&emsp;&emsp;所求解集为：
````
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
````

**提示：**

* 1 <= candidates.length <= 30
* 1 <= candidates[i] <= 200
* candidate 中的每个元素都是独一无二的。
* 1 <= target <= 500



### 解题思路

&emsp;&emsp;使用 dfs 思想，首先确定一个元素，然后向后递归，再确定一个元素再递归（该元素可能与上一个元素相同），
直到元素和 > target 或者指针越界时，结束递归。如果元素和 = target，结束递归并将该集合的元素添加到结果集中。
回溯：每次遇见一个新的数值有两种选择：1、使用该元素进行递归；2、不使用该元素直接进行递归。所以当我们一个递归使用该元素，那么另一个递归就要不使用该元素。

### 代码

[代码链接](Solution1.java)

![提交记录](39(1).png)

**优化**

[代码链接](Solution2.java)

![提交记录](39(2).png)