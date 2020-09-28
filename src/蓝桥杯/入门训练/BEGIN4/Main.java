package 蓝桥杯.入门训练.BEGIN4;

import java.util.Scanner;

/**
 * @date 2020-09-19
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        if (r == 1 || r == 2) {
            System.out.println(1);
            return;
        }
        int a = 1;
        int b = 1;
        r -= 2;
        while (r > 0) {
            int tmp = (a + b) % 10007;
            a = b;
            b = tmp;
            r--;
        }
        System.out.println(b);
    }

}
