package com.gewuyou.algorithm.problem;

/**
 * 476. 数字的补数
 *
 * @author gewuyou
 * @since 2024-04-18 下午2:42:36
 */
public class ComplementsOfNumbers {
    public int findComplement(int num) {
        int n = 1;
        // 构造一个长度与num一样位数的但二进制位全部是1的数
        while ((num & n) != num) {
            n = (n << 1) + 1;
        }
        // 通过异或操作求出补数
        return num ^ n;
    }

    public static void main(String[] args) {
        ComplementsOfNumbers solution = new ComplementsOfNumbers();
        int num = 5;
        int result = solution.findComplement(num);
        System.out.println(result);
    }
}
