package 力扣.普通题.困难.SerialNumber37;

/**
 * @date 2020-09-17
 */
public class Util {

    /**
     * 用来测试
     */
    public static void main(String[] args) {
        System.out.println(Integer.toString(0x1ff, 2));
        System.out.println(0x1ff);
        char[][] a = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution3().solveSudoku(a);
    }

    /**
     * 输出结果
     */
    public static void print(char[][] table) {
        for (int i = 0; i < 9; i++) {
            System.out.println(table[i]);
        }
    }
}
