package com.gewuyou.algorithm.test;

import java.util.Scanner;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Test
 * @apiNote
 * @since 2022/9/23 16:20
 */
public class Test {
    private static  final int Kh = 171;
    private static final int Is = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Double Vn = sc.nextDouble();
            System.out.println(calculate(Vn)*1000);
        }
    }

    private static  double calculate (Double Vn) {
        return Vn/(Kh*Is);
    }
}

