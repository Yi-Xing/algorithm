package 力扣.普通题.中等.SerialNumber75;

/**
 * @date 2020-09-05
 */
public class Solution {

    public void sortColors(int[] nums) {
        // 指针用来遍历数组
        int p = 0;
        // 指针指向0
        int p0 = 0;
        // 指针指向2
        int p2 = nums.length - 1;
        int temp;
        while (p <= p2) {
            if (nums[p] == 0) {
                temp = nums[p0];
                nums[p0++] = nums[p];
                nums[p++] = temp;
            } else if (nums[p] == 2) {
                temp = nums[p2];
                nums[p2--] = nums[p];
                nums[p] = temp;
            } else {
                p++;
            }
        }
    }
}
