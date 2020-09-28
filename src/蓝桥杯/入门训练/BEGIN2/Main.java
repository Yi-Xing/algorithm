package 蓝桥杯.入门训练.BEGIN2;

import java.util.Scanner;

/**
 * @date 2020-09-19
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
