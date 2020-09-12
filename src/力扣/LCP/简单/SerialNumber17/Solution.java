package 力扣.LCP.简单.SerialNumber17;

/**
 * @date 2020-09-12
 */
public class Solution {

    public int calculate(String s) {
        char[] array = s.toCharArray();
        int x = 1;
        int y = 0;
        for (char c : array) {
            if (c == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

}