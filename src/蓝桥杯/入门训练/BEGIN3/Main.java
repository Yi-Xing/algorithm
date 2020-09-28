package 蓝桥杯.入门训练.BEGIN3;

import java.util.Scanner;

/**
 * @date 2020-09-19
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        System.out.printf("%7.7f", Math.PI * Math.pow(r, 2));
    }

}
