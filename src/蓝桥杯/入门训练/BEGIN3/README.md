## 圆的面积

**链接**：http://lx.lanqiao.cn/problem.page?gpid=T3

### 题目

**资源限制**

&emsp;&emsp;时间限制：1.0s   内存限制：256.0MB

**问题描述**

&emsp;&emsp;给定圆的半径r，求圆的面积。

**输入格式**

&emsp;&emsp;输入包含一个整数r，表示圆的半径。

**输出格式**

&emsp;&emsp;输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积。

**样例输入**

&emsp;&emsp;4

**样例输出**

&emsp;&emsp;50.2654825

**数据规模与约定**

&emsp;&emsp;1 <= r <= 10000。

### 解题思路

&emsp;&emsp;圆面积公司：π * r^2，题目的要点是四舍五入保留小数点后7位，可以使用 printf 对结果进行格式化。

### 代码

[代码链接](Main.java)

|得分|CPU使用|内存使用|
|:---:|:---:|:---:|
|100|109ms|23.63MB|


