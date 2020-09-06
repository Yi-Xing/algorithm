package 力扣.普通题.中等.SerialNumber60;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020-09-05
 */
public class Solution {

    /**
     * 存储 1-n的数字
     */
    static List<Integer> number = new ArrayList<>();
    /**
     * 存储结果
     */
    static StringBuffer result;

    public String getPermutation(int n, int k) {
        // 每次调用初始化结果集
        result = new StringBuffer();
        // 存储 n 的阶乘
        int factorial = 1;
        number.add(1);
        // 求出n的阶乘的值，并将1-n的数存入 number 中
        for (int i = 2; i <= n; i++) {
            factorial = factorial * i;
            number.add(i);
        }
        getPermutation(n, factorial, k);
        return result.toString();
    }

    /**
     * @param n         的值
     * @param factorial n的阶乘
     * @param k         第几个
     */
    public static void getPermutation(int n, int factorial, int k) {
        // 当n为0结束循环
        if (n == 0) {
            return;
        }
        // 求出区间数
        int section = factorial / n;
        // 用于判断k是不是区间数的倍数
        int ranking = k % section;
        // k所在几号区间，对应 number 中的数
        int index;
        if (ranking == 0) {
            // 如果成立
            // k在几号区间=k/（区间+1）
            index = k / (section + 1);
            // k在区间的位置等于区间数
            k = section;
        } else {
            // k在几号区间=k/区间
            index = k / section;
            // k在区间的位置=k%区间
            k = ranking;

        }
        // 将number中该数删除，加入结果集中
        result.append(number.remove(index));
        // 已经确定了一个数所以n-1；n的区间数，就n-1的阶乘
        getPermutation(n - 1, section, k);
    }
}
