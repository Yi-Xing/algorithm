package 力扣.LCP.简单.SerialNumber18;

import java.util.Arrays;

/**
 * @date 2020-09-12
 */
public class Solution {


    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(drinks);
        long sum = 0;
        System.out.println(Arrays.toString(drinks));
        for (int i : staple) {
            System.out.println("i:" + i + "," + sum);
            sum += commonBinarySearch(drinks, x - i);
            System.out.println("i:" + i + "," + sum + "\n\n");
        }
        return (int) (sum % 1000000007);
    }

    public int commonBinarySearch(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        int middle;
        if (key < arr[min]) {
            return 0;
        }
        if (key > arr[max]) {
            return arr.length;
        }

        while (min <= max) {
            middle = (min + max) / 2;
            if (arr[middle] > key) {
                //比关键字大则关键字在左区域
                max = middle - 1;
            } else if (arr[middle] < key) {
                //比关键字小则关键字在右区域
                min = middle + 1;
            } else {
                // 查找到后往后遍历，为了防止数组中有相同的数
                while (middle < arr.length - 1 && arr[middle] == arr[middle + 1]) {
                    middle++;
                }
                return middle + 1;
            }
        }
        return min;
    }


}
