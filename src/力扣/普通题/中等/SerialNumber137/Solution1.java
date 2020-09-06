package 力扣.普通题.中等.SerialNumber137;


import java.util.*;

/**
 * @date 2020-09-05
 */
public class Solution1 {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long count = 0;
        for (int i : nums) {
            set.add(i);
            count += i;
        }
        long countSet = 0;
        for (Integer i : set) {
            countSet += i;
        }
        return (int) ((countSet * 3 - count) / 2);
    }


}
