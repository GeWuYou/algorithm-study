package com.gewuyou.algorithm.test;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Test2
 * @apiNote </br>
 * @since 2022/11/26 16:56
 */

public class Test2 {

    public static void main(String[] args) {
        System.out.println(f(15));
    }
    private static int f(int n)
    {
        if(n < 1) {
            return 0;
        }
        if(n <= 4) {
            return 1;
        }
        return f(n - 1) + f(n - 2) + f(n - 3) + f(n - 4);
    }
}

