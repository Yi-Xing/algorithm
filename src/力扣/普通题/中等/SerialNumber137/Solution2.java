package 力扣.普通题.中等.SerialNumber137;

import java.util.*;

/**
 * @date 2020-09-05
 */
public class Solution2 {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(1^0);
        System.out.println(1^1);
        System.out.println(1&0);
        System.out.println(1&1);
    }
}
